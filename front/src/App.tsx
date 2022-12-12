import './App.css'
import { ChangeEvent, FormEvent, MouseEventHandler, useState } from 'react'

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

const Table: React.FC<{ news: News[] }> = ({ news }) => {
  if (news.length == 0) {
    return <></>;
  }
  return <table id="table">
    <caption>History</caption>
    <thead>
      <tr>
        <th>News</th>
        <th>Algorithm</th>
        <th>Percentage (%)</th>
      </tr>
    </thead>
    <tbody>
      {news.slice(0, 5).map((news) => (
        <tr key={news.key}>
          <ReadMore>{news.content}</ReadMore>
          <td>{news.algorithm}</td>
          <td>{news.percentage.toFixed(2)}%</td>
        </tr>
      ))}
    </tbody>
  </table>
}

const intToAlgorithm = (id: number): 'cosine' | 'jaro-winkler' | 'levenshtein' => {
  if (id == 0) {
    return 'cosine';
  } else if (id == 1) {
    return 'jaro-winkler';
  } else {
    return 'levenshtein';
  }
}

const handleClick: MouseEventHandler = (event) => {
  document.getElementById("uploadFile")?.click();
  event.preventDefault();
}

const handleChange = (event: ChangeEvent) => {
  const button = document.getElementById("uploadFileInput") as HTMLButtonElement;
  const input = event.target as HTMLInputElement;
  button.innerText = `Selected file - ${input.files![0].name}`;
}

const getPercentage = async (route: string, data: FormData) => {
  let request = await fetch("http://localhost:8080/" + route, {
    method: 'POST',
    headers: {
      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Credentials': 'true'
    },
    body: data
  });

  return await request.json() as number * 100;
}

let currKey = 0;

function App() {

  const [news, setNews] = useState<News[]>([]);
  const [disabled, setDisabled] = useState<boolean>(false);

  const handleSubmit = async (event: FormEvent) => {
    event.preventDefault();
    const form = event.target as HTMLFormElement;
    const data = new FormData(form);

    const file = data.get('file') as File;
    const newsText = data.get('news') as string;

    setDisabled(true);
    document.body.style.cursor = 'wait';

    let percentage;
    if (file.size != 0) {
      data.delete('news');
      percentage = await getPercentage("accuracy/file", data);
    } else if (newsText) {
      data.delete('file');
      percentage = await getPercentage("accuracy", data);
    } else {
      return;
    }

    const idAlgorithm = data.get('idAlgorithm') as string;

    const newNews = {
      content: file.name || newsText || '', percentage, algorithm: intToAlgorithm(+idAlgorithm), key: currKey++
    };

    document.body.style.cursor = 'default';
    setNews([newNews, ...news]);
    setDisabled(false);
  }

  return (
    <div className="App">
      <h1><b>Fake News Detector</b></h1>
      <form id="form" encType="multipart/form-data" onSubmit={handleSubmit}>
        <span>Insert your text:</span>

        <textarea name="news" placeholder="Your text goes here"></textarea>

        <span className="center">OR</span>

        <button id="uploadFileInput" className='primary' onClick={handleClick}>upload csv file</button>
        <input id="uploadFile" type="file" accept=".csv" name="file" onChange={handleChange} hidden />

        <hr />

        <span>Select an Algorithm:</span>


        <select name="idAlgorithm" defaultValue="" required>
          <option value="" disabled>-- select an algorithm --</option>
          <option value={0}>Cosine Algorithm</option>
          <option value={1}>Jaro-Winkler Algorithm</option>
          <option value={2}>Levenshtein Distance Algorithm</option>
        </select>

        <hr />

        <button className='secondary' disabled={disabled}>Find The Truth!</button>
      </form>
      <br /><br />
      <Table news={news} />
    </div>
  )
}

export default App
