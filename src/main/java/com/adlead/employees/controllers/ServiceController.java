package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.models.Service;
import com.adlead.employees.services.ServiceService;

@RestController
@RequestMapping("api/services")
@CrossOrigin("*")
public class ServiceController {
	
	private ServiceService serviceService;
	
	@Autowired
	public ServiceController(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public List<Service> getAll() {
		return this.serviceService.getAll();
	}
	
	@PostMapping("/")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Service save(@RequestBody Service service) {
		return this.serviceService.save(service);
	}
	

}
