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

import com.adlead.employees.models.Professionnel;
import com.adlead.employees.services.ProfessionnelService;

@RestController
@RequestMapping("api/professionnels")
public class ProfessionnelController {
	
	private ProfessionnelService professionnelService;
	
	@Autowired
	public ProfessionnelController(ProfessionnelService professionnelService) {
		this.professionnelService = professionnelService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Professionnel save(@RequestBody Professionnel professionnel) {
		return this.professionnelService.save(professionnel);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Professionnel> findByEmployeId(@PathVariable(name = "id") long id) {
		return this.professionnelService.findByEmployeId(id);
	}

}
