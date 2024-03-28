import Table from 'react-bootstrap/Table';
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
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Costume ID</th>
          <th>Costume</th>
        </tr>
      </thead>
      <tbody>
        {costumes.map(costume => (
          <tr key={costume.costumeId}>
          <td>{costume.costumeId}</td>
            <td>{costume.costumeName}</td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
};

export default CostumeList;
