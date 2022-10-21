package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Conge;
import com.adlead.employees.models.Demande_Conge;
import com.adlead.employees.models.Etat_Conge;
import com.adlead.employees.repositories.DemandeCongeRepo;

@Service
public class DemandeCongeService {
	
	private DemandeCongeRepo demandeCongeRepo;
	private CongeService congeService;
	
	@Autowired
	public DemandeCongeService(DemandeCongeRepo demandeCongeRepo, CongeService congeService) {
		this.demandeCongeRepo = demandeCongeRepo;
		this.demandeCongeRepo = demandeCongeRepo;
		this.congeService = congeService;
	}
	
	public Demande_Conge save(Demande_Conge demande) throws Exception {
		if(demande.getEtat()==null) demande.setEtat(new Etat_Conge("En Attente", null));
		else {
			if(demande.getEtat().getEtat().equals("Confirmée")) {
				Conge conge = this.congeService.getById(demande.getConge().getId_conge());
				if(conge.getNb_jours() >= demande.getNb_jour()) {
					conge.setNb_jours(conge.getNb_jours()-demande.getNb_jour());
					conge = this.congeService.save(conge);
					demande.setConge(conge);
				}else throw new Exception("Vous n'avez pas suffisant conge");
			}
		}
		return this.demandeCongeRepo.save(demande);
	}
	
	public List<Demande_Conge> getByEtat(String etatName){
		Etat_Conge etat = new Etat_Conge(etatName, null);
		return this.demandeCongeRepo.findAllDemande_CongesByEtat(etat);
	}
	
	public List<Demande_Conge> getAll(){
		return this.demandeCongeRepo.findAll();
	}

}
