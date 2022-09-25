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
		return this.serviceRepo.save(service);
	}
	
	public com.adlead.employees.models.Service findById(long id){
		return this.serviceRepo.findById(id).get();
	}
	
	public void delete(long id) {
		this.serviceRepo.deleteById(id);
	}
	
	public com.adlead.employees.models.Service edit(com.adlead.employees.models.Service service){
		com.adlead.employees.models.Service old = this.findById(service.getId_service());
		old.setNom_service(service.getNom_service());
		return this.serviceRepo.save(old);
	}

}
