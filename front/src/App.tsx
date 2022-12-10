import './App.css'
import { Children, useState } from 'react'

var showChar = 120;

type News = {
  content: string;
  algorithm: "cosine" | "jaro-winkler" | "levenshtein";
  percentage: number;
}

let news: News[] = [{ content: "bla", algorithm: "cosine", percentage: 50},{ content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.", algorithm: "jaro-winkler", percentage: 50}];

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

const UploadFile = () => {
  document.getElementById("uploadFile")?.click();
}

function App() {
  return (
    <div className="App">
      <h1><b>Fake News Detector</b></h1>
      <div className="detector">
        <span>Insert your text:</span>

        <textarea placeholder="Your text goes here"></textarea>

        <span className="center">OR</span>

        <button className='primary' onClick={UploadFile}>upload csv file</button>
        <input id="uploadFile" type="file" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" hidden/>

        <hr />

        <span>Select an Algorithm:</span>


        <select>
          <option disabled selected>-- select an algorithm --</option>
          <option value={0}>Cosine Algorithm</option>
          <option value={1}>Jaro-Winkler Algorithm</option>
          <option value={2}>Levenshtein Distance Algorithm</option>
        </select>

        <hr />

        <button className='secondary'>Find The Truth!</button>
      </div>
      <br/><br/>
      <table>
        <caption>History</caption>
        <br/>
        <tr>
          <th>News</th>
          <th>Algorithm</th>
          <th>Percentage (%)</th>
        </tr>
        {news.map((news) => (
        <tr>
          <ReadMore>{news.content}</ReadMore>
          <td>{news.algorithm}</td>
          <td>{news.percentage}</td>
        </tr>
        ))}       
      </table>
    </div>
  )
}

export default App
