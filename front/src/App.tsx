import './App.css'
import { useState } from 'react'

var showChar = 120;

type News = {
  content: string;
  algorithm: "cosine" | "jaro-winkler" | "levenshtein";
  percentage: number;
  key: number;
}

const ReadMore: React.FC<{ children: string }> = ({ children }) => {
  const text = children;
  const size = children.length;
  const [isReadMore, setIsReadMore] = useState(true);

  const toggleReadMore = () => {
    setIsReadMore(!isReadMore);
  };

  if (size <= showChar) {
    return (<td> {text} </td>);
  } else {
    return (
      <td>
        {isReadMore ? text.substring(0, showChar) : text}
        <span onClick={toggleReadMore} className="read-or-hide">
          {isReadMore ? " read more [+]" : " show less"}
        </span>
      </td>
    )
  }
};

const intToAlgorithm = (id: number) => {
  console.log(id);
  if (id == 0) {
    return 'cosine';
  } else if (id == 1) {
    return 'jaro-winkler';
  } else {
    return 'levenshtein';
  }
}

const handleClick = (event: MouseEvent) => {
  document.getElementById("uploadFile")?.click();
  event.preventDefault();
}

const handleChange = (event) => {
  document.getElementById("uploadFileInput")!.innerText = `Selected file - ${event.target.files[0].name}`;
}

let currKey = 0;

function App() {

  const [news, setNews] = useState<News[]>([]);
  const [disabled, setDisabled] = useState<boolean>(false);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const form = event.target;
    const data = new FormData(form);
    const file = data.get('file');
    const newsText = data.get('news');
    let request;
    setDisabled(true);
    document.body.style.cursor = 'wait';
    if (file.size != 0) {
      data.delete('news');
      request = await fetch("http://localhost:8080/uploadFile", {
        method: 'POST',
        headers: {
          'Access-Control-Allow-Origin': 'http://localhost:8080',
          'Access-Control-Allow-Credentials': 'true'
        },
        body: data
      });
    } else if (newsText) {
      data.delete('file');
      request = await fetch("http://localhost:8080/testText", {
        method: 'POST',
        headers: {
          'Access-Control-Allow-Origin': 'http://localhost:8080',
          'Access-Control-Allow-Credentials': 'true'
        },
        body: data
      });
    }
    let percentage: number = await request?.json() * 100;
    document.body.style.cursor = 'default';
    let newNews = {
      content: file?.name || newsText || '', percentage, algorithm: intToAlgorithm(data.get('idAlgorithm')), key: currKey++
    };
    setNews([newNews, ...news]);
    setDisabled(false);

    if (document.getElementById("table")!.style.display = 'none') {
      document.getElementById("table")!.style.display = 'table';
    }
  }

  return (
    <div className="App">
      <h1><b>Fake News Detector</b></h1>
      <form id="form" enctype="multipart/form-data" onSubmit={handleSubmit}>
        <span>Insert your text:</span>

        <textarea name="news" placeholder="Your text goes here"></textarea>

        <span className="center">OR</span>

        <button id="uploadFileInput" className='primary' onClick={handleClick}>upload csv file</button>
        <input id="uploadFile" type="file" accept=".csv" name="file" onChange={handleChange} hidden />

        <hr />

        <span>Select an Algorithm:</span>


        <select name="idAlgorithm" required>
          <option value="" disabled selected>-- select an algorithm --</option>
          <option value={0}>Cosine Algorithm</option>
          <option value={1}>Jaro-Winkler Algorithm</option>
          <option value={2}>Levenshtein Distance Algorithm</option>
        </select>

        <hr />

        <button className='secondary' disabled={disabled}>Find The Truth!</button>
      </form>
      <br /><br />
      <table id="table">
        <caption>History</caption>
        <br />
        <tr>
          <th>News</th>
          <th>Algorithm</th>
          <th>Percentage (%)</th>
        </tr>
        {news.slice(0, 5).map((news) => (
          <tr key={news.key}>
            <ReadMore>{news.content}</ReadMore>
            <td>{news.algorithm}</td>
            <td>{news.percentage.toFixed(2)}%</td>
          </tr>
        ))}
      </table>
    </div>
  )
}

export default App
