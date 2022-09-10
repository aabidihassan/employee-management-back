package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Statut;
import com.adlead.employees.services.StatutService;

@RestController
@RequestMapping("api/statuts")
public class StatutController {
	
	private StatutService statutService;
	
	@Autowired
	public StatutController(StatutService statutService) {
		this.statutService = statutService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Statut> getAll(){
		return this.statutService.getAll();
	}

}
