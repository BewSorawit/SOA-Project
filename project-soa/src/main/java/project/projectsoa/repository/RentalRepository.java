package project.projectsoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import project.projectsoa.model.Customer;
import project.projectsoa.model.Rental;
//import project.projectsoa.model.Rentaldetail;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

}