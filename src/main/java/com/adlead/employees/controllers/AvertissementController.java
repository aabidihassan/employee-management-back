package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.dto.RechercheAvertissement;
import com.adlead.employees.models.Avertissement;
import com.adlead.employees.services.AvertissementService;

@RestController
@RequestMapping("api/avertissements")
public class AvertissementController {
	
	private AvertissementService avertissementService;
	
	@Autowired
	public AvertissementController(AvertissementService avertissementService) {
		this.avertissementService = avertissementService;
	}
	
	@PostMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public Avertissement save(@RequestBody Avertissement avertissement){
        return this.avertissementService.save(avertissement);
    }
	
	@PostMapping("/search")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<Avertissement> findByCritiques(@RequestBody RechercheAvertissement rechercheAvertissement){
        return this.avertissementService.getAvertissementByCritiques(rechercheAvertissement);
    }
	
	@GetMapping("/{id}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable(name="id") long id){
        this.avertissementService.delete(id);
    }

}
