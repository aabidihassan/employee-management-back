package com.adlead.employees.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	@Id @Column(length = 20)
    private String poste;
	
	@ManyToOne @JsonIgnoreProperties("fonctions")
	private Service service;
	
	@OneToOne(mappedBy = "fonction") @JsonIgnoreProperties("fonction")
	private Employe employe;

}