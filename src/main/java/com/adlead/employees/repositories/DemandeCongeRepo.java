package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Demande_Conge;
import com.adlead.employees.models.Etat_Conge;

@Repository
public interface DemandeCongeRepo extends JpaRepository<Demande_Conge, Long>{
	
	public List<Demande_Conge> findAllDemande_CongesByEtat(Etat_Conge etat);

}
