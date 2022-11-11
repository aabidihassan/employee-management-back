package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.SanctionToEmploye;

@Repository
public interface SanctionToEmployeRepo extends JpaRepository<SanctionToEmploye, Long>{
	
	@Query("select s from SanctionToEmploye s where s.date>=:de and s.date<=:jusqua and s.employe=:employe")
	public List<SanctionToEmploye> findAllSanctionToEmployesByDateAndEmploye(
			@Param("de") String de, 
			@Param("jusqua") String jusqua, 
			@Param("employe") Employe employe);
	
	@Query("select s from SanctionToEmploye s where s.date>=:de and s.date<=:jusqua")
	public List<SanctionToEmploye> findAllSanctionToEmployesByDate(
			@Param("de") String de, 
			@Param("jusqua") String jusqua);

}
