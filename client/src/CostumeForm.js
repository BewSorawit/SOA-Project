// CostumeForm.js
import React, { useState } from 'react';
import axios from 'axios';

const CostumeForm = () => {
  const [name, setName] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/costumes`, { name });
      console.log('Costume created:', response.data);
      // Reset form fields after successful submission
      setName('');
    } catch (error) {
      console.error('Error creating costume:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      <button type="submit">Add Costume</button>
    </form>
  );
};

export default CostumeForm;
