import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Custume from './components/Custume';
import CustumeType from './components/CustumeType';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <h1>Custume Booking System</h1>
          <nav>
            <ul>
              <li><a href="/">Custume</a></li>
              <li><a href="/custumetype">Custume Type</a></li>
            </ul>
          </nav>
        </header>
        <main>
          <Routes>
            <Route path="/" element={<Custume />} />
            <Route path="/custumetype" element={<CustumeType />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
