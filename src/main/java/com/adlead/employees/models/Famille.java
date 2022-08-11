package com.adlead.employees.models;

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
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Famille {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_famille;

    /**
     * 
     */
    private int nb_enfants;

    /**
     * 
     */
    private int nb_enfants_adult;
    
    @OneToOne(mappedBy = "famille", fetch = FetchType.EAGER) @JsonIgnoreProperties("famille")
    private Employe employe;
    
    @ManyToOne @JsonIgnoreProperties("familles")
    private Situation_famille situation_famille;

}