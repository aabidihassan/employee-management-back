package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.dto.RechercheAvertissement;
import com.adlead.employees.models.MiseAPied;
import com.adlead.employees.repositories.MiseAPiedRepo;

@Service
public class MiseAPiedService {
	
	private MiseAPiedRepo miseAPiedRepo;
	
	@Autowired
	public MiseAPiedService(MiseAPiedRepo miseAPiedRepo) {
		this.miseAPiedRepo = miseAPiedRepo;
	}
	
	public MiseAPied save(MiseAPied miseAPied) {
		return this.miseAPiedRepo.save(miseAPied);
	}
	
	public List<MiseAPied> getMiseAPiedByCritiques(RechercheAvertissement rechercheAvertissement){
		return this.miseAPiedRepo.findAllMiseAPiedsByDate(rechercheAvertissement.getDe(), 
						rechercheAvertissement.getJusqua());
	}
	
	public void delete(long id) {
		this.miseAPiedRepo.deleteById(id);
	}

}
