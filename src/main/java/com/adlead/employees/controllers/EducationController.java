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

import com.adlead.employees.models.Education;
import com.adlead.employees.services.EducationService;

@RestController
@RequestMapping("api/educations")
public class EducationController {
	
	private EducationService educationService;
	
	@Autowired
	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Education save(@RequestBody Education education) {
		return this.educationService.save(education);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Education> findByEmployeId(@PathVariable(name = "id") long id) {
		return this.educationService.findByEmploye(id);
	}

}
