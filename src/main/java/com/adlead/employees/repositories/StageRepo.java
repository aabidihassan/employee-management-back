package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Stage;

@Repository
public interface StageRepo extends JpaRepository<Stage, Long>{
	
	List<Stage> findStagesByEmploye(Employe employe);

}
