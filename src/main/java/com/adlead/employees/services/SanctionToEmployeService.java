package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.dto.RechercheAvertissement;
import com.adlead.employees.models.SanctionToEmploye;
import com.adlead.employees.repositories.SanctionToEmployeRepo;

@Service
public class SanctionToEmployeService {
	
	private SanctionToEmployeRepo sanctionToEmployeRepo;
	
	@Autowired
	public SanctionToEmployeService(SanctionToEmployeRepo sanctionToEmployeRepo) {
		this.sanctionToEmployeRepo = sanctionToEmployeRepo;
	}
	
	public SanctionToEmploye save(SanctionToEmploye sanctionToEmploye) {
		return this.sanctionToEmployeRepo.save(sanctionToEmploye);
	}
	
	public List<SanctionToEmploye> getAll(){
		return this.sanctionToEmployeRepo.findAll();
	}
	
	public void delete(long id) {
		this.sanctionToEmployeRepo.deleteById(id);
	}
	
	public List<SanctionToEmploye> getSanctionsByCritiques(RechercheAvertissement rechercheAvertissement){
		return rechercheAvertissement.getEmploye() !=null ? this.sanctionToEmployeRepo.findAllSanctionToEmployesByDateAndEmploye(
				rechercheAvertissement.getDe(), rechercheAvertissement.getJusqua(), 
				rechercheAvertissement.getEmploye()) 
				: this.sanctionToEmployeRepo.findAllSanctionToEmployesByDate(rechercheAvertissement.getDe(), 
						rechercheAvertissement.getJusqua());
	}

}
