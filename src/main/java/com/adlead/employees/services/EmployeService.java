package com.adlead.employees.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Employe_Creation;
import com.adlead.employees.models.Employe_Edit;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.repositories.EmployeRepo;

@Service
public class EmployeService {
	
	private EmployeRepo employeRepo;
	private UtilisateurService utilisateurService;
	
	@Autowired
	public EmployeService(EmployeRepo employeRepo, UtilisateurService utilisateurService) {
		this.employeRepo = employeRepo;
		this.utilisateurService = utilisateurService;
	}
	
	public List<Employe> getAll(){
		return this.employeRepo.findAll();
	}
	
	public Employe save(Employe employe, Utilisateur user) {
		employe.setCreation(new Employe_Creation(0, new Date(), employe, user));
		return this.employeRepo.save(employe);
	}
	
	public void delete(long id) {
		this.employeRepo.deleteById(id);
	}
	
	public Employe getById(long id) {
		return this.employeRepo.findById(id).get();
	}
	
	public Employe modify(Employe employe, Utilisateur user) {
		Employe emp = this.getById(employe.getId_employe());
		emp.setNom(employe.getNom());
		emp.setPrenom(employe.getPrenom());
		emp.setAdresse(employe.getAdresse());
		emp.setCin(employe.getCin());
		emp.setEmail(employe.getEmail());
		emp.setTelephone(employe.getTelephone());
		emp.setSex(employe.getSex());
		emp.setNaissance(employe.getNaissance());
		emp.setMatricule(employe.getMatricule());
		emp.setStatut(employe.getStatut());
		emp.getModifications().add((new Employe_Edit(0, new Date(), emp, user)));
		return this.employeRepo.save(emp);
	}

}
