package com.adlead.employees.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Fonction {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_fonction;
	
	
    private String poste;
	
	@ManyToOne @JsonIgnoreProperties("fonctions")
	private Service service;
	
	@OneToMany(mappedBy = "fonction") @JsonIgnoreProperties("fonction")
	private List<Employe> employes = new ArrayList<Employe>();

}