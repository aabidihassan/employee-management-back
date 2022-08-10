package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.AppRole;

@Repository
public interface RoleRepo extends JpaRepository<AppRole, String> {

    AppRole findByLibelle(String libelle);

}
