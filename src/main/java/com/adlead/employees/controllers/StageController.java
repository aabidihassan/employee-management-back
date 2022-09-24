package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Stage;
import com.adlead.employees.services.StageService;

@RestController
@RequestMapping("api/stages")
public class StageController {

	private StageService stageService;
	
	@Autowired
	public StageController(StageService stageService) {
		this.stageService = stageService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Stage save(@RequestBody Stage stage) {
		return this.stageService.save(stage);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Stage> findByEmployeId(@PathVariable(name = "id") long id) {
		return this.stageService.findByEmployeId(id);
	}
}
