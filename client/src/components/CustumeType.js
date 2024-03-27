// CustumeType.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CustumeType = () => {
  const [custumeTypes, setCustumeTypes] = useState([]);

  useEffect(() => {
    axios.get(`${process.env.REACT_APP_API_URL}/custume-types`)
      .then(response => {
        setCustumeTypes(response.data);
      })
      .catch(error => {
        console.error('Error fetching custume types: ', error);
      });
  }, []);

  return (
    <div>
      <h1>Custume Types</h1>
      <ul>
        {custumeTypes.map(custumeType => (
          <li key={custumeType.typeId}>
            {custumeType.typeName}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CustumeType;
