// CostumeTypeList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/Table';

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
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Costume ID</th>
          <th>Costume</th>
        </tr>
      </thead>
      <tbody>
        {costumeTypes.map(costumeType => (
          <tr key={costumeType.typeId}>
          <td>{costumeType.typeId}</td> 
            <td>{costumeType.typeName}</td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
};

export default CostumeTypeList;
