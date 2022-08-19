package com.adlead.employees.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Employe;
import com.adlead.employees.services.EmployeService;

@RestController
@RequestMapping("api/employes")
public class EmployeController {
	
	private EmployeService employeService;
	
	@Autowired
	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Employe> getAll(){
		return this.employeService.getAll();
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Employe save(@RequestBody Employe employe, Principal principal){
		return this.employeService.save(employe);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(@PathVariable(name = "id") long id) {
		this.employeService.delete(id);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Employe getById(@PathVariable(name = "id") long id){
		return this.employeService.getById(id);
	}
	
	@PutMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Employe modify(@RequestBody Employe employe, Principal principal){
		return this.employeService.modify(employe);
	}

}
