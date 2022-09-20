package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Fonction;
import com.adlead.employees.services.FonctionService;

@RestController
@RequestMapping("api/fonctions")
public class FonctionConntroller {
	
	private FonctionService fonctionService;
	
	@Autowired
	public FonctionConntroller(FonctionService fonctionService) {
		this.fonctionService = fonctionService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Fonction> getAll(){
		return this.fonctionService.getAll();
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Fonction save(@RequestBody Fonction fonction){
		return this.fonctionService.save(fonction);
	}

}
