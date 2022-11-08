package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.services.UtilisateurService;


@RestController
@RequestMapping("api/users")
public class UtilisateurController {
	
	private UtilisateurService utilisateurService;
	
	@Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }
	
	@GetMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public List<Utilisateur> listUsers(){
        return utilisateurService.listUsers();
    }
	
	@GetMapping("/{username}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public Utilisateur getUserByUsername(@PathVariable String username){
        return this.utilisateurService.loadUserByUsername(username);
    }

}
