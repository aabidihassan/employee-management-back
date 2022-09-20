package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Fonction;

@Repository
public interface FonctionRepo extends JpaRepository<Fonction, Long>{

}
