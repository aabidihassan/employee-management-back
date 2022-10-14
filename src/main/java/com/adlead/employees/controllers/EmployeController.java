package com.adlead.employees.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adlead.employees.models.Employe;
import com.adlead.employees.services.EmployeService;
import com.adlead.employees.services.UtilisateurService;

@RestController
@RequestMapping("api/employes")
@CrossOrigin(origins = "*")
public class EmployeController {
	
	private EmployeService employeService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	public EmployeController(EmployeService employeService, UtilisateurService utilisateurService) {
		this.employeService = employeService;
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Employe> getAll(){
		return this.employeService.getAll();
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Employe save(@RequestParam(name = "employe") String employe, @RequestParam(name = "photo") MultipartFile photo ,Principal principal) throws IOException{
		return this.employeService.save(employe, photo, utilisateurService.loadUserByUsername(principal.getName()));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(@PathVariable(name = "id") long id) {
		this.employeService.delete(id);
	}
	
//	@GetMapping("/{id}")
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
//	public Employe getById(@PathVariable(name = "id") long id){
//		return this.employeService.getById(id);
//	}
	
	@PostMapping("/edit")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Employe modify(@RequestBody Employe employe, Principal principal){
		return this.employeService.modify(employe, utilisateurService.loadUserByUsername(principal.getName()));
	}

}
