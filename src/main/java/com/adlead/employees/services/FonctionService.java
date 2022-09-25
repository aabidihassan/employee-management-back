package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Fonction;
import com.adlead.employees.repositories.FonctionRepo;

@Service
public class FonctionService {
	
	private FonctionRepo fonctionRepo;
	
	@Autowired
	public FonctionService(FonctionRepo fonctionRepo) {
		this.fonctionRepo = fonctionRepo;
	}
	
	public List<Fonction> getAll(){
		return this.fonctionRepo.findAll();
	}
	
	public Fonction save(Fonction fonction) {
		return this.fonctionRepo.save(fonction);
	}
	
	public void delete(long id) {
		this.fonctionRepo.deleteById(id);
	}
	
	public Fonction findById(long id) {
		return this.fonctionRepo.findById(id).get();
	}
	
	public Fonction edit(Fonction fonction) {
		Fonction old = this.findById(fonction.getId_fonction());
		old.setPoste(fonction.getPoste());
		return this.fonctionRepo.save(old);
	}

}
