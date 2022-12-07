package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Enquette;
import com.adlead.employees.services.EnquetteService;

@RestController
@RequestMapping("api/enquettes")
public class EnquetteController {
	
	private EnquetteService enquetteService;
	
	@Autowired
	public EnquetteController(EnquetteService enquetteService) {
		this.enquetteService = enquetteService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Enquette save(@RequestBody Enquette enquette) {
		return this.enquetteService.save(enquette);
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Enquette> getAll(){
		return this.enquetteService.getAll();
	}

}
