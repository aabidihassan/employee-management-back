package com.adlead.employees.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adlead.employees.models.AppRole;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.repositories.RoleRepo;
import com.adlead.employees.repositories.UtilisateurRepo;

@Service
@Transactional
public class AccountServiceImpl {

    private RoleRepo roleRepo;
    private UtilisateurRepo utilisateurRepo;

    @Autowired
    public AccountServiceImpl(RoleRepo roleRepo, UtilisateurRepo utilisateurRepo, PasswordEncoder passwordEncoder){
        this.roleRepo = roleRepo;
        this.utilisateurRepo = utilisateurRepo;
    }

    public void affectRoleToUser(String username, String role) {
        Utilisateur user = utilisateurRepo.findByUsername(username);
        AppRole role1 = roleRepo.findByLibelle(role);
        user.getRoles().add(role1);
        role1.getUsers().add(user);
    }
    
    public void delete(Utilisateur user) {
    	this.utilisateurRepo.delete(user);
    }
    
}
