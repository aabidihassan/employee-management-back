package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.dto.RechercheDto;
import com.adlead.employees.models.Avertissement;
import com.adlead.employees.repositories.AvertissementRepo;

@Service
public class AvertissementService {
	
	private AvertissementRepo avertissementRepo;
	
	@Autowired
	public AvertissementService(AvertissementRepo avertissementRepo) {
		this.avertissementRepo = avertissementRepo;
	}
	
	public Avertissement save(Avertissement avertissement) {
		return this.avertissementRepo.save(avertissement);
	}
	
	public List<Avertissement> getAvertissementByCritiques(RechercheDto rechercheAvertissement){
		return rechercheAvertissement.getEmploye() !=null ? this.avertissementRepo.findAllAvertissementsByDateAndEmploye(
				rechercheAvertissement.getDe(), rechercheAvertissement.getJusqua(), 
				rechercheAvertissement.getEmploye()) 
				: this.avertissementRepo.findAllAvertissementsByDate(rechercheAvertissement.getDe(), 
						rechercheAvertissement.getJusqua());
	}
	
	public void delete(long id) {
		this.avertissementRepo.deleteById(id);
	}

}
