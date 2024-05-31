import React, { Component } from 'react'
import {Navbar,Nav} from 'react-bootstrap'
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from './Home';
import CostumeForm from './CostumeForm';
import CostumeList from './CostumeList';
import CostumeTypeList from './CostumeTypeList';

export default class NavbarComp extends Component{
    render(){
        return(
            <Router>
            <div>
                <Navbar expand="lg" className="bg-body-tertiary">
        <Navbar.Brand href="/">React-Bootstrap</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to={"/costumeForm"}>Costume Form</Nav.Link>
            <Nav.Link as={Link} to={"/costumeList"}>Costume List</Nav.Link>
            <Nav.Link as={Link} to={"/costumeTypeList"}>Costume Type List</Nav.Link>
          </Nav>
        </Navbar.Collapse>
    </Navbar>

            </div>
            <div>
            
                <Routes>
                <Route path="/costumeForm" element={<CostumeForm/>}>
            </Route>
            <Route path="/costumeList" element={<CostumeList/>}>
            </Route>
            <Route path="/costumeTypeList" element={<CostumeTypeList/>}>
            </Route>
            <Route path="/" element={<Home/>}>
            </Route>
            </Routes>
            </div>
            </Router>
        )
    }
}