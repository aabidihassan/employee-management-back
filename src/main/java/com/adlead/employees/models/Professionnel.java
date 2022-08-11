package com.adlead.employees.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@DiscriminatorValue("professionnel")
public class Professionnel extends Champs_CV {

    /**
     * 
     */
    private String entreprise;

    /**
     * 
     */
    private String poste;

}