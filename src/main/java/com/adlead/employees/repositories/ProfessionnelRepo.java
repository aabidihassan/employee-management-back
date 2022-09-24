package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Professionnel;

@Repository
public interface ProfessionnelRepo extends JpaRepository<Professionnel, Long>{
	
	List<Professionnel> findProfessionnelsByEmploye(Employe employe);

}
