package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Conge;
import com.adlead.employees.services.CongeService;

@RestController
@RequestMapping("api/conges")
public class CongeController {
	
	private CongeService congeService;
	
	@Autowired
	public CongeController(CongeService congeService) {
		this.congeService = congeService;
	}
	
	@GetMapping("/{annee}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Conge> save(@PathVariable(name = "annee") int annee) {
		return this.congeService.getAllByAnnee(annee);
	}

}
