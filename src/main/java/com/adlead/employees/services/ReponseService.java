package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Enquette;
import com.adlead.employees.models.Reponse;
import com.adlead.employees.repositories.ReponseRepo;

@Service
public class ReponseService {
	
	private ReponseRepo reponseRepo;
	
	@Autowired
	public ReponseService(ReponseRepo reponseRepo) {
		this.reponseRepo = reponseRepo;
	}
	
	public Reponse save(Reponse reponse) {
		return this.reponseRepo.save(reponse);
	}
	
	public List<Reponse> getAllByEnquette(Enquette enquette){
		return this.reponseRepo.findAllReponsesByEnquette(enquette);
	}

}
