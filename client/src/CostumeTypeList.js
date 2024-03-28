// CostumeTypeList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CostumeTypeList = () => {
  const [costumeTypes, setCostumeTypes] = useState([]);

  useEffect(() => {
    axios.get(`${process.env.REACT_APP_API_URL}/custume-types`)
      .then(response => {
        setCostumeTypes(response.data);
      })
      .catch(error => {
        console.error('Error fetching costume types:', error);
      });
  }, []);

  return (
    <div>
      <h2>Costume Types</h2>
      <ul>
        {costumeTypes.map(costumeType => (
          <li key={costumeType.typeId}>{costumeType.typeName}</li>
        ))}
      </ul>
    </div>
  );
};

export default CostumeTypeList;
