package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Enquette;
import com.adlead.employees.models.Reponse;

@Repository
public interface ReponseRepo extends JpaRepository<Reponse, Long>{
	
	public List<Reponse> findAllReponsesByEnquette(Enquette enquette);

}