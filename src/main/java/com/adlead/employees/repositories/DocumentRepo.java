package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long>{

}
