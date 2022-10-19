package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@Id
	private long id_conge;
	
	private int annee;

    /**
     * 
     */
    private int nb_jours;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "conge")
    @Fetch(FetchMode.SUBSELECT)
    private List<Demande_Conge> demandes = new ArrayList<Demande_Conge>();
    
    @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("conges")
    private Employe employe;

}