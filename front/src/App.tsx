import './App.css'

function App() {
  return (
    <div className="App">
      <h1>Fake News Detector</h1>
      <div class="detector">
        <span>insert your text here:</span>

        <textarea></textarea>

        <span className="center">or</span>

        <button className='primary'>upload csv file</button>

        <hr />

        <span>select an algorithm:</span>


        <select>
          <option disabled selected>select an algorithm</option>
          <option value={0}>bla bla</option>
          <option value={1}>ble ble</option>
          <option value={2}>bli bli</option>
        </select>

        <hr />

        <button className='secondary'>find the truth!</button>
      </div>

      <span>history</span>

      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec eros imperdiet, suscipit ipsum ac, efficitur turpis. Sed ultrices hendrerit libero, laoreet lacinia erat pretium ac.</p>
    </div>
  )
}

export default App
