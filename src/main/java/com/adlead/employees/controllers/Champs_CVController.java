package com.adlead.employees.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Champs_CV;
import com.adlead.employees.services.Champs_CVService;
import com.adlead.employees.services.UtilisateurService;

@RestController
@RequestMapping("api/cv")
public class Champs_CVController {
	
	private Champs_CVService champs_CVService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	public Champs_CVController(Champs_CVService champs_CVService, UtilisateurService utilisateurService) {
		this.champs_CVService = champs_CVService;
		this.utilisateurService = utilisateurService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Champs_CV save(@RequestBody Champs_CV champs, Principal principal){
		return this.champs_CVService.save(champs, utilisateurService.loadUserByUsername(principal.getName()));
	}

}
