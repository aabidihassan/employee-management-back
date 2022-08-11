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
@DiscriminatorValue("education")
public class Education extends Champs_CV {

    /**
     * 
     */
    private String filiere;

    /**
     * 
     */
    private String diplome;

}