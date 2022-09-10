package com.adlead.employees.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(length = 1)
    private String situation;
    
    @OneToOne(mappedBy = "famille", fetch = FetchType.EAGER) @JsonIgnoreProperties("famille")
    private Employe employe;

}