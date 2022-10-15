package com.adlead.employees.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Document {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_document;

    /**
     * 
     */
    private String fichier;
    
    private String description;
    
    @ManyToOne @JsonIgnore
    private Employe employe;

}