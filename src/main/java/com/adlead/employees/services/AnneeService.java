package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Annee;
import com.adlead.employees.repositories.AnneeRepo;

@Service
public class AnneeService {
	
	private AnneeRepo anneeRepo;
	
	@Autowired
	public AnneeService(AnneeRepo anneeRepo) {
		this.anneeRepo = anneeRepo;
	}
	
	public List<Annee> getAll(){
		return this.anneeRepo.findAll();
	}

}
