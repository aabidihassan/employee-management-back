package com.adlead.employees.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private String date_debut;

    /**
     * 
     */
    private String date_fin;
    
    private int nb_jour;
    
    @ManyToOne
    private Employe adjoint;
    
    @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("demandes")
    private Conge conge;
    
    @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("demandes")
    private Etat_Conge etat;

}