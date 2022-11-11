package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Sanction;
import com.adlead.employees.services.SanctionService;

@RestController
@RequestMapping("api/sanctions")
public class SanctionController {
	
	private SanctionService sanctionService;
	
	@Autowired
	public SanctionController(SanctionService sanctionService) {
		this.sanctionService = sanctionService;
	}
	
	@PostMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public Sanction save(@RequestBody Sanction sanction){
        return this.sanctionService.save(sanction);
    }
	
	@GetMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<Sanction> getAll(){
        return this.sanctionService.getAll();
    }

}
