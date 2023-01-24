import "./App.css"
import {BrowserRouter , Routes , Route} from "react-router-dom"
import Home from "./pages/Home/Home";

//continue from 1:16:15 npm install firebase  https://www.youtube.com/watch?v=AJmqb_Q3ojA


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path='/' element={<Home/>} />
          {/* <Route exact path='/login' element={<Login/>} />
          <Route exact path='/signup' element={<Signup/>} /> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
