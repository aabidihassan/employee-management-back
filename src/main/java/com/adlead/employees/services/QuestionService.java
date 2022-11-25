package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Question;
import com.adlead.employees.repositories.QuestionRepo;

@Service
public class QuestionService {
	
	private QuestionRepo questionRepo;
	
	@Autowired
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public Question save(Question question) {
		return this.questionRepo.save(question);
	}
	
	public List<Question> getAll(){
		return this.questionRepo.findAll();
	}

}
