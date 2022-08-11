package com.adlead.employees.models;

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
public class Demande_Conge {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_demande;

    /**
     * 
     */
    private Date date_debut;

    /**
     * 
     */
    private Date date_fin;
    
    @ManyToOne @JsonIgnoreProperties("demandes")
    private Conge conge;
    
    @ManyToOne @JsonIgnoreProperties("demandes")
    private Etat_Conge etat;
    
    @ManyToOne @JsonIgnoreProperties("demandes")
    private Employe employe;

}