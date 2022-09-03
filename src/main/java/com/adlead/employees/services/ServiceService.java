package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.repositories.ServiceRepo;

@Service
public class ServiceService {
	
	private ServiceRepo serviceRepo;
	
	@Autowired
	public ServiceService(ServiceRepo serviceRepo) {
		this.serviceRepo = serviceRepo;
	}
	
	public List<com.adlead.employees.models.Service> getAll() {
		return this.serviceRepo.findAll();
	}
	
	public com.adlead.employees.models.Service save(com.adlead.employees.models.Service service){
		return this.save(service);
	}
	
	public com.adlead.employees.models.Service findById(long id){
		return this.serviceRepo.findById(id).get();
	}

}
