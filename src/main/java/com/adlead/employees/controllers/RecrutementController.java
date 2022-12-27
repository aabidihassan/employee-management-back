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

import com.adlead.employees.dto.RechercheDto;
import com.adlead.employees.models.Recrutement;
import com.adlead.employees.services.RecrutementService;

@RestController
@RequestMapping("api/recrutement")
public class RecrutementController {
	
	private RecrutementService recrutementService;
	
	@Autowired
	public RecrutementController(RecrutementService recrutementService) {
		this.recrutementService = recrutementService;
	}
	
	@PostMapping("/search")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Recrutement> findByCritiques(@RequestBody RechercheDto rechercheAvertissement){
        return this.recrutementService.getRecrutementsByCritiques(rechercheAvertissement);
    }
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement save(@RequestBody Recrutement recrutement) {
		return this.recrutementService.save(recrutement);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public void delete(@PathVariable(name = "id") long id) {
		this.recrutementService.delete(id);
	}
	
	@GetMapping("/accept/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement accept(@PathVariable(name = "id") long id) {
		return this.recrutementService.accept(id);
	}
	
	@GetMapping("/decline/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement decline(@PathVariable(name = "id") long id) {
		return this.recrutementService.decline(id);
	}

}
