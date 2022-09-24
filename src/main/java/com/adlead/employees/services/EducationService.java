package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Education;
import com.adlead.employees.models.Employe;
import com.adlead.employees.repositories.EducationRepo;

@Service
public class EducationService {
	
	private EducationRepo educationRepo;
	
	@Autowired
	public EducationService(EducationRepo educationRepo) {
		this.educationRepo = educationRepo;
	}
	
	public Education save(Education education) {
		return this.educationRepo.save(education);
	}
	
	public List<Education> findByEmploye(long id){
		Employe emp = new Employe();
		emp.setId_employe(id);
		return this.educationRepo.findEducationsByEmploye(emp);
	}

}
