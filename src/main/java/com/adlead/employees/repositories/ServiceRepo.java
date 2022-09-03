package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long>{

}
