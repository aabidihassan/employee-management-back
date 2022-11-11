package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Sanction;
import com.adlead.employees.repositories.SanctionRepo;

@Service
public class SanctionService {
	
	private SanctionRepo sanctionRepo;
	
	@Autowired
	public SanctionService(SanctionRepo sanctionRepo) {
		this.sanctionRepo = sanctionRepo;
	}
	
	public Sanction save(Sanction sanction) {
		return this.sanctionRepo.save(sanction);
	}
	
	public List<Sanction> getAll(){
		return this.sanctionRepo.findAll();
	}

}
