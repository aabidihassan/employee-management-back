package com.adlead.employees.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Demande_Conge;
import com.adlead.employees.services.DemandeCongeService;

@RestController
@RequestMapping("api/conges/demande")
public class DemandeCongeController {
	
	private DemandeCongeService demandeCongeService;
	
	@Autowired
	public DemandeCongeController(DemandeCongeService demandeCongeService) {
		this.demandeCongeService = demandeCongeService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Demande_Conge save(@RequestBody Demande_Conge demande) {
		return this.demandeCongeService.save(demande);
	}

}
