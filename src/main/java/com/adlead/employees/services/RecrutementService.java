package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Recrutement;
import com.adlead.employees.repositories.RecrutementRepo;

@Service
public class RecrutementService {
	
	private RecrutementRepo recrutementRepo;
	
	@Autowired
	public RecrutementService(RecrutementRepo recrutementRepo) {
		this.recrutementRepo = recrutementRepo;
	}
	
	public List<Recrutement> getAll(){
		return this.recrutementRepo.findAll();
	}
	
	public Recrutement save(Recrutement recrutement) {
		return this.recrutementRepo.save(recrutement);
	}
	
	public Recrutement findById(long id) {
		return this.recrutementRepo.findById(id).get();
	}
	
	public Recrutement changeStatut(long id, boolean statut) {
		Recrutement recrutement = this.findById(id);
		recrutement.setStatut(statut);
		return this.save(recrutement);
	}

}
