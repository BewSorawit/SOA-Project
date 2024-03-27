// NavBar.js
import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/costumes">Costumes</Link>
        </li>
        <li>
          <Link to="/costume-types">Costume Types</Link>
        </li>
      </ul>
    </nav>
  );
};

export default NavBar;
