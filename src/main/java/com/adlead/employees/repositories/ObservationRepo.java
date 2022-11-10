package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Observation;

@Repository
public interface ObservationRepo extends JpaRepository<Observation, Long>{
	
	@Query("select o from Observation o where o.date>=:de and o.date<=:jusqua and o.employe=:employe")
	public List<Observation> findAllObservationsByDateAndEmploye(
			@Param("de") String de, 
			@Param("jusqua") String jusqua, 
			@Param("employe") Employe employe);
	
	@Query("select o from Observation o where o.date>=:de and o.date<=:jusqua")
	public List<Observation> findAllObservationsByDate(
			@Param("de") String de, 
			@Param("jusqua") String jusqua);

}
