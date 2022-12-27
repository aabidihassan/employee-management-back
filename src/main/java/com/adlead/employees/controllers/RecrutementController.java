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
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Recrutement> findAll(){
		return this.recrutementService.getAll();
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement save(@RequestBody Recrutement recrutement) {
		return this.recrutementService.save(recrutement);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement findById(@PathVariable(name = "id") long id) {
		return this.recrutementService.findById(id);
	}
	
	@GetMapping("/{id}/{statut}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Recrutement changeStatut(@PathVariable(name = "id") long id, @PathVariable(name = "statut") boolean statut) {
		return this.recrutementService.changeStatut(id, statut);
	}

}
