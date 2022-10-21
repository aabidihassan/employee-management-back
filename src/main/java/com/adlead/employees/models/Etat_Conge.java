package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Etat_Conge {

    /**
     * 
     */
	@Id @Column(length = 10)
    private String etat;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "etat") @JsonIgnore
    private List<Demande_Conge> demandes = new ArrayList<Demande_Conge>(); 

}