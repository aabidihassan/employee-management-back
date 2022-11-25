package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Enquette;

@Repository
public interface EnquetteRepo extends JpaRepository<Enquette, Long>{

}
