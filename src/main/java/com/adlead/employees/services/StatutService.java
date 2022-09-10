package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Statut;
import com.adlead.employees.repositories.StatutRepo;

@Service
public class StatutService {

	private StatutRepo statutRepo;
	
	@Autowired
	public StatutService(StatutRepo statutRepo) {
		this.statutRepo = statutRepo;
	}
	
	public List<Statut> getAll(){
		return this.statutRepo.findAll();
	}
	
}
