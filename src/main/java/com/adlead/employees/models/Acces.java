package com.adlead.employees.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Acces {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_acces;

    /**
     * 
     */
    private Date date_creation;

    /**
     * 
     */
    private Date date_modification;
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "acces") @JsonIgnoreProperties("acces")
    private Employe employe;
    
    @ManyToOne @JsonIgnoreProperties("acces")
    private Utilisateur user;

}