package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Long>{
	
	public List<Employe> findAllEmployesByActive(boolean bool);

}
