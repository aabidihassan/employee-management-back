package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Avertissement;
import com.adlead.employees.models.Employe;

@Repository
public interface AvertissementRepo extends JpaRepository<Avertissement, Long>{
	
	@Query("select a from Avertissement a where a.date>=:de and a.date<=:jusqua and a.employe=:employe")
	public List<Avertissement> findAllAvertissementsByDateAndEmploye(
			@Param("de") String de, 
			@Param("jusqua") String jusqua, 
			@Param("employe") Employe employe);
	
	@Query("select a from Avertissement a where a.date>=:de and a.date<=:jusqua")
	public List<Avertissement> findAllAvertissementsByDate(
			@Param("de") String de, 
			@Param("jusqua") String jusqua);

}
