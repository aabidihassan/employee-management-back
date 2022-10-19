package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Conge;

@Repository
public interface CongeRepo extends JpaRepository<Conge, Long>{
	
	public List<Conge> findAllCongesByAnnee(int annee);

}
