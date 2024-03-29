package com.adlead.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

}
