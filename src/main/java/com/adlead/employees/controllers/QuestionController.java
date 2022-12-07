package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Question;
import com.adlead.employees.services.QuestionService;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
	
	private QuestionService questionService;
	
	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Question save(@RequestBody Question question) {
		return this.questionService.save(question);
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Question> getAll(){
		return this.questionService.getAll();
	}

}
