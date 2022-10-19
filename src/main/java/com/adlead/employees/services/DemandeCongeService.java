package com.adlead.employees.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Demande_Conge;
import com.adlead.employees.repositories.DemandeCongeRepo;

@Service
public class DemandeCongeService {
	
	private DemandeCongeRepo demandeCongeRepo;
	
	@Autowired
	public DemandeCongeService(DemandeCongeRepo demandeCongeRepo) {
		this.demandeCongeRepo = demandeCongeRepo;
	}
	
	public Demande_Conge save(Demande_Conge demande) {
		return this.demandeCongeRepo.save(demande);
	}

}
