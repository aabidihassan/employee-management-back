package com.adlead.employees.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Id @Column(length = 20)
    private String poste;
	
	@OneToMany(mappedBy = "fonction") @JsonIgnoreProperties("fonction")
	private List<Employe> employe = new ArrayList<Employe>();

}