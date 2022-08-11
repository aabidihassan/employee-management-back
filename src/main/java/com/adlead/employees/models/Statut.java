package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Statut {

    /**
     * 
     */
	@Id @Column(length = 10)
    private String statut_libelle;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "statut") @JsonIgnoreProperties("statut")
    private List<Employe> employes = new ArrayList<Employe>();

}