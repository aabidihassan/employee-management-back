package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Annee;
import com.adlead.employees.services.AnneeService;

@RestController
@RequestMapping("api/annees")
public class AnneeController {
	
	private AnneeService anneeService;
	
	@Autowired
	public AnneeController(AnneeService anneeService) {
		this.anneeService = anneeService;
	}
	
	@GetMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER', 'USER')")
    public List<Annee> profile(){
        return this.anneeService.getAll();
    }

}
