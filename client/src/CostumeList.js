// CostumeList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CostumeList = () => {
  const [costumes, setCostumes] = useState([]);

  useEffect(() => {
    axios.get(`${process.env.REACT_APP_API_URL}/custumes`)
      .then(response => {
        setCostumes(response.data);
      })
      .catch(error => {
        console.error('Error fetching costumes:', error);
      });
  }, []);

  return (
    <div>
      <h2>Costumes</h2>
      <ul>
        {costumes.map(costume => (
          <li key={costume.costumeId}>{costume.costumeName}</li>
        ))}
      </ul>
    </div>
  );
};

export default CostumeList;
