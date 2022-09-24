package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Education;
import com.adlead.employees.models.Employe;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{
	
	List<Education> findEducationsByEmploye(Employe employe);

}
