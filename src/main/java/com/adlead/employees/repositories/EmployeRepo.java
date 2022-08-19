package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Long>{

}
