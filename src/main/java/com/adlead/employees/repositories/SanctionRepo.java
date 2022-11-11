package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Sanction;

@Repository
public interface SanctionRepo extends JpaRepository<Sanction, Long>{

}
