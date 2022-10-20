package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Annee;

@Repository
public interface AnneeRepo extends JpaRepository<Annee, Integer>{

}
