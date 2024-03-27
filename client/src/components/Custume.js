// Custume.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Custume = () => {
  const [custumes, setCustumes] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/custumes')
      .then(response => {
        setCustumes(response.data);
      })
      .catch(error => {
        console.error('Error fetching custumes: ', error);
      });
  }, []);

  return (
    <div>
      <h1>Custumes</h1>
      <table>
        <thead>
          <tr>
            <th>Costume ID</th>
            <th>Costume Name</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {custumes.map(custume => (
            <tr key={custume.costumeId}>
              <td>{custume.costumeId}</td>
              <td>{custume.costumeName}</td>
              <td>{custume.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Custume;
