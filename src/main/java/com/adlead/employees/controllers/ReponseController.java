package com.adlead.employees.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Reponse;
import com.adlead.employees.services.ReponseService;

@RestController
@RequestMapping("api/reponses")
public class ReponseController {
	
	private ReponseService reponseService;
	
	@Autowired
	public ReponseController(ReponseService reponseService) {
		this.reponseService = reponseService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Reponse save(@RequestBody Reponse reponse) {
		return this.reponseService.save(reponse);
	} 

}
