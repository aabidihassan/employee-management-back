package com.adlead.employees.models;

import java.util.Date;

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
public class Detail_RH {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detail;

    /**
     * 
     */
    private String date_embauche;

    /**
     * 
     */
    private String num_cnss;

    /**
     * 
     */
    private String rip;
    
    private String type_contrat;
    
    private String banque;
    
    @OneToOne(mappedBy = "detailsRH", fetch = FetchType.EAGER) @JsonIgnoreProperties("detailsRH")
    private Employe employe;
    
    private String mode_paiment;
    
    private boolean recruteur;

}