import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CostumeForm = () => {
  const [name, setName] = useState('');
  const [costumeTypes, setCostumeTypes] = useState([]);
  const [selectedType, setSelectedType] = useState('');
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

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
      setErrorMessage('Costume Type can\'t be empty.');
      return;
    }
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/custumes`, { costumeName: name, costumeType: { typeId: selectedType }, status: 'Available' });
      console.log('Costume created:', response.data);
      setName('');
      setSelectedType('');
      setSuccessMessage('Costume added successfully.');
      setErrorMessage('');
      setTimeout(() => {
        setSuccessMessage('');
      }, 5000);
    } catch (error) {
      console.error('Error creating costume:', error);
    }
  };

  return (
    <div className="container mt-4">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h2 className="card-title">Add New Costume</h2>
              {errorMessage && (
                <div className="alert alert-danger" role="alert">
                  {errorMessage}
                </div>
              )}
              {successMessage && (
                <div className="alert alert-success" role="alert">
                  {successMessage}
                </div>
              )}
              <form onSubmit={handleSubmit}>
                <div className="form-group">
                  <label htmlFor="name">Costume Name:</label>
                  <input 
                    type="text" 
                    className="form-control" 
                    id="name" 
                    value={name} 
                    onChange={(e) => setName(e.target.value)} 
                    placeholder="Enter Costume Name" 
                    required 
                  />
                </div>
                <div className="form-group mt-2">
                  <label htmlFor="type">Costume Type:</label>
                  <select 
                    className="form-control" 
                    id="type" 
                    value={selectedType} 
                    onChange={(e) => setSelectedType(e.target.value)} 
                    required
                  >
                    <option value="">Select Costume Type</option>
                    {costumeTypes.map((type) => (
                      <option key={type.typeId} value={type.typeId}>{type.typeName}</option>
                    ))}
                  </select>
                </div>
                <button type="submit" className="btn btn-primary mt-2">Add Costume</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CostumeForm;
