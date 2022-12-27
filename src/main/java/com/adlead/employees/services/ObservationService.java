package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.dto.RechercheDto;
import com.adlead.employees.models.Observation;
import com.adlead.employees.repositories.ObservationRepo;

@Service
public class ObservationService {
	
	private ObservationRepo observationRepo;
	
	@Autowired
	public ObservationService(ObservationRepo observationRepo) {
		this.observationRepo = observationRepo;
	}
	
	public Observation save(Observation observation) {
		return this.observationRepo.save(observation);
	}
	
	public List<Observation> getObservationByCritiques(RechercheDto rechercheAvertissement){
		return rechercheAvertissement.getEmploye() !=null ? this.observationRepo.findAllObservationsByDateAndEmploye(
				rechercheAvertissement.getDe(), rechercheAvertissement.getJusqua(), 
				rechercheAvertissement.getEmploye()) 
				: this.observationRepo.findAllObservationsByDate(rechercheAvertissement.getDe(), 
						rechercheAvertissement.getJusqua());
	}
	
	public void delete(long id) {
		this.observationRepo.deleteById(id);
	}

}
