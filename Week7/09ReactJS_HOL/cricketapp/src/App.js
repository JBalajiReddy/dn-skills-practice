import IndianPlayers from "./Components/IndianPlayers";
import ListOfPlayers from "./Components/ListOfPlayers";

function App() {
  const flag = true;

  return (
    <div className="App">
      <h1>Cricket App</h1>
      {flag ? <ListOfPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
