package com.adlead.employees.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reponse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_reponse;
	
	private boolean reponse;
	
	@ManyToOne
	private Enquette enquette;
	
	@ManyToOne
	private Employe employe;

}
