package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Recrutement;

@Repository
public interface RecrutementRepo extends JpaRepository<Recrutement, Long>{
	
	@Query("select r from Recrutement r where r.date>=:de and r.date<=:jusqua and r.demendeur=:demendeur")
	public List<Recrutement> findAllRecrutementsByDateAndDemandeur(
			@Param("de") String de, 
			@Param("jusqua") String jusqua, 
			@Param("demendeur") Employe employe);
	
	@Query("select r from Recrutement r where r.date>=:de and r.date<=:jusqua")
	public List<Recrutement> findAllRecrutementsByDate(
			@Param("de") String de, 
			@Param("jusqua") String jusqua);

}
