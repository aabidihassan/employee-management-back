package com.adlead.employees.models;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Contrat {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_contrat;

    /**
     * 
     */
    private Date date_debut;

    /**
     * 
     */
    private Date date_fin;

    /**
     * 
     */
    private String desciption;

    /**
     * 
     */
    private String fichier;
    
    @ManyToOne @JsonIgnoreProperties("contrats")
    private Type_Contrat type;
    
    @ManyToOne @JsonIgnoreProperties("contrats")
    private Employe employe;

}