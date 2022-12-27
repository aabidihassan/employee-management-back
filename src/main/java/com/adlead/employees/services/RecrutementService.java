package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.dto.RechercheDto;
import com.adlead.employees.models.Recrutement;
import com.adlead.employees.repositories.EmployeRepo;
import com.adlead.employees.repositories.RecrutementRepo;

@Service
public class RecrutementService {
	
	private RecrutementRepo recrutementRepo;
	private EmployeRepo employeRepo;
	
	@Autowired
	public RecrutementService(RecrutementRepo recrutementRepo, EmployeRepo employeRepo) {
		this.recrutementRepo = recrutementRepo;
		this.employeRepo = employeRepo;
	}
	
	public Recrutement save(Recrutement recrutement) {
		return this.recrutementRepo.save(recrutement);
	}
	
	public Recrutement findById(long id) {
		return this.recrutementRepo.findById(id).get();
	}
	
	public Recrutement accept(long id) {
		Recrutement recrutement = this.findById(id);
		recrutement.setStatut(true);
		recrutement.getDemendeur().setFonction(recrutement.getFonction());
		this.employeRepo.save(recrutement.getDemendeur());
		return this.save(recrutement);
	}
	
	public Recrutement decline(long id) {
		Recrutement recrutement = this.findById(id);
		recrutement.setStatut(false);
		return this.save(recrutement);
	}
	
	public void delete(long id) {
		this.recrutementRepo.deleteById(id);
	}
	
	public List<Recrutement> getRecrutementsByCritiques(RechercheDto rechercheAvertissement){
		return rechercheAvertissement.getEmploye() !=null ? this.recrutementRepo.findAllRecrutementsByDateAndDemandeur(
				rechercheAvertissement.getDe(), rechercheAvertissement.getJusqua(), 
				rechercheAvertissement.getEmploye()) 
				: this.recrutementRepo.findAllRecrutementsByDate(rechercheAvertissement.getDe(), 
						rechercheAvertissement.getJusqua());
	}

}
