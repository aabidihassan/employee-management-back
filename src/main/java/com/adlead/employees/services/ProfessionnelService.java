package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Professionnel;
import com.adlead.employees.repositories.ProfessionnelRepo;

@Service
public class ProfessionnelService {
	
	private ProfessionnelRepo professionnelRepo;
	
	@Autowired
	public ProfessionnelService(ProfessionnelRepo professionnelRepo) {
		this.professionnelRepo = professionnelRepo;
	}
	
	public Professionnel save(Professionnel professionnel) {
		return this.professionnelRepo.save(professionnel);
	}
	
	public List<Professionnel> findByEmployeId(long id){
		Employe emp = new Employe();
		emp.setId_employe(id);
		return this.professionnelRepo.findProfessionnelsByEmploye(emp);
	}

}
