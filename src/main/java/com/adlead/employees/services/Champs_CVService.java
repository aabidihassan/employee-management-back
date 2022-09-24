package com.adlead.employees.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Champs_CV;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.repositories.Champs_CVRepo;

@Service
public class Champs_CVService {
	
	private Champs_CVRepo champs_CVRepo;
	private EmployeService employeService;
	
	@Autowired
	public Champs_CVService(Champs_CVRepo champs_CVRepo, EmployeService employeService) {
		this.champs_CVRepo = champs_CVRepo;
		this.employeService = employeService;
	}
	
	public Champs_CV save(Champs_CV champs_CV, Utilisateur user) {
		champs_CV.setEmploye(this.employeService.setModification(champs_CV.getEmploye(), user));
		return this.champs_CVRepo.save(champs_CV);
	}

}
