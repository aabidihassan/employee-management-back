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
@DiscriminatorValue("stage")
public class Stage extends Champs_CV {

    /**
     * 
     */
    private String entreprise;

    /**
     * 
     */
    private String sujet;

}