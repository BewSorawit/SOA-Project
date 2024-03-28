import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CostumeForm = () => {
  const [name, setName] = useState('');
  const [costumeTypes, setCostumeTypes] = useState([]);
  const [selectedType, setSelectedType] = useState('');

  useEffect(() => {
    const fetchCostumeTypes = async () => {
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_URL}/custume-types`);
        setCostumeTypes(response.data);
      } catch (error) {
        console.error('Error fetching costume types:', error);
      }
    };

    fetchCostumeTypes();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!selectedType) {
      console.error('Please select a costume type.');
      return;
    }
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/custumes`, { costumeName: name, custumeType: { typeId: selectedType }, status: 'Available' });
      console.log('Costume created:', response.data);
      setName('');
      setSelectedType('');
    } catch (error) {
      console.error('Error creating costume:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Costume Name" />
      <select value={selectedType} onChange={(e) => setSelectedType(e.target.value)}>
        <option value="" disabled hidden>Select Costume Type</option>
        {costumeTypes.map((type) => (
          <option key={type.typeId} value={type.typeId}>{type.typeName}</option>
        ))}
      </select>
      <button type="submit">Add Costume</button>
    </form>
  );
};

export default CostumeForm;
