package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Conge;
import com.adlead.employees.repositories.CongeRepo;

@Service
public class CongeService {
	
	private CongeRepo congeRepo;
	
	@Autowired
	public CongeService(CongeRepo congeRepo) {
		this.congeRepo = congeRepo;
	}
	
	public List<Conge> getAllByAnnee(int annee){
		return this.congeRepo.findAllCongesByAnnee(annee);
	}
	
	public Conge save(Conge conge) {
		return this.congeRepo.save(conge);
	}

}
