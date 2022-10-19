package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Demande_Conge;

@Repository
public interface DemandeCongeRepo extends JpaRepository<Demande_Conge, Long>{

}
