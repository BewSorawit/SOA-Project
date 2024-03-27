// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './Navbar';
import Home from './Home';
import CostumeList from './CostumeList';
import CostumeTypeList from './CostumeTypeList';

const App = () => {
  return (
    <Router>
      <div>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/costumes" element={<CostumeList />} />
          <Route path="/costume-types" element={<CostumeTypeList />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
