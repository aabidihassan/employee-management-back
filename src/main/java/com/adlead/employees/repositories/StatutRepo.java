package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Statut;

@Repository
public interface StatutRepo extends JpaRepository<Statut, String>{

}
