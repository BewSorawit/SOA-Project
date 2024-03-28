// App.js
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import NavBarComp from './Navbar';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Login'
import Signup from './Signup'

const App = () => {
  return (
    <div className="App">
      <NavBarComp/>
      <BrowserRouter>
        <Routes>
          <Route path='/Login' element={<Login />}></Route>
          <Route path='/signup' element={<Signup />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
