package com.adlead.employees.models;

import java.io.File;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Champs_CV {
	
	 /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_champs;

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
    private String description;

    /**
     * 
     */
    private String attestation;
    
    @ManyToOne @JsonIgnoreProperties("champs")
    private Employe employe;

}