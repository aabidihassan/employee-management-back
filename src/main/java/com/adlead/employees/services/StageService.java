package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Stage;
import com.adlead.employees.repositories.StageRepo;

@Service
public class StageService {
	
	private StageRepo stageRepo;
	
	@Autowired
	public StageService(StageRepo stageRepo) {
		this.stageRepo = stageRepo;
	}
	
	public Stage save(Stage stage) {
		return this.stageRepo.save(stage);
	}
	
	public List<Stage> findByEmployeId(long id){
		Employe emp = new Employe();
		emp.setId_employe(id);
		return this.stageRepo.findStagesByEmploye(emp);
	}

}
