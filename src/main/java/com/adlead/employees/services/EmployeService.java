package com.adlead.employees.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.AppRole;
import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Employe_Creation;
import com.adlead.employees.models.Employe_Edit;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.repositories.EmployeRepo;

@Service
public class EmployeService {
	
	private EmployeRepo employeRepo;
	private EmailSenderService emailSenderService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public EmployeService(EmployeRepo employeRepo, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
		this.employeRepo = employeRepo;
		this.emailSenderService = emailSenderService;
		this.passwordEncoder = passwordEncoder;
	}
	
	public List<Employe> getAll(){
		return this.employeRepo.findAllEmployesByActive(true);
	}
	
	public Employe save(Employe employe, Utilisateur user) {
		employe.setCreation(new Employe_Creation(0, new Date(), employe, user));
		employe.setActive(true);
		return this.employeRepo.save(employe);
	}
	
	public void delete(long id) {
		Employe emp = this.getById(id);
		emp.setActive(false);
		this.employeRepo.save(emp);
	}
	
	public Employe getById(long id) {
		return this.employeRepo.findById(id).get();
	}
	
	public void sendEmail(Employe employe, Utilisateur user) {
    	this.emailSenderService.sendEmail(employe.getEmail(), "Votre Compte", 
    			"Bonjour "+employe.getNom()+ " " + employe.getPrenom() +
    			", \nVotre compte pour la plateforme de gestion des employes est bien cree. "
    			+ "\nVous pouvez authentifier en utilisant: \nNom d'utilisateur : "
    					+ user.getUsername() + "\nMot de passe : "+user.getPassword()
    					+ "\nBonne reception.");
    }
	
	public String generatePassword() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		         + "0123456789"
		         + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			 
			   // generate a random number between
			   // 0 to AlphaNumericString variable length
			   int index
			    = (int)(AlphaNumericString.length()
			      * Math.random());
			 
			   // add Character one by one in end of sb
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
		return sb.toString();
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
		emp.setFonction(employe.getFonction());
		emp.setFamille(employe.getFamille());
		if(emp.getDetailsRH() == null && employe.getDetailsRH() != null) {
			if(employe.getDetailsRH().isRecruteur()) {
				Utilisateur account = new Utilisateur();
				account.setUsername(employe.getPrenom().charAt(0) + "." + employe.getNom());
				account.setUsername(account.getUsername().toLowerCase());
				account.setPassword(this.generatePassword());
				account.getRoles().add(new AppRole("USER", null));
				this.sendEmail(emp, account);
				account.setPassword(this.passwordEncoder.encode(account.getPassword()));
				emp.setUser(account);
			}
		}
		if(employe.getUser()!=null) {
			emp.getUser().setUsername(employe.getUser().getUsername());
			emp.getUser().setRoles(employe.getUser().getRoles());
			if(employe.getUser().getPassword()!=null)
			emp.getUser().setPassword(this.passwordEncoder.encode(employe.getUser().getPassword()));
		}
		
		emp.setDetailsRH(employe.getDetailsRH());
		return this.setModification(emp, user);
	}
	
	public Employe setModification(Employe emp, Utilisateur user) {
		if(emp.getModification() == null) emp.setModification(new Employe_Edit());
		emp.getModification().setDate_modification(new Date());
		emp.getModification().setUser(user);
		emp.getModification().setEmploye(emp);
		return this.employeRepo.save(emp);
	}

}
