package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {

    Utilisateur findByUsername(String username);

}
