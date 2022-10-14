package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.AppFile;

@Repository
public interface AppFileRepo extends JpaRepository<AppFile, Long>{

}
