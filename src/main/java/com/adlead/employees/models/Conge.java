package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Conge {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_conge;

    /**
     * 
     */
    private int nb_jours;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "conge") @JsonIgnoreProperties("conge")
    private List<Demande_Conge> demandes = new ArrayList<Demande_Conge>();

}