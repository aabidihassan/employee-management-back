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
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Type_Contrat {

    /**
     * 
     */
	@Id @Column(length = 10)
    private String type;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type") @JsonIgnoreProperties("type")
    private List<Contrat> contrats = new ArrayList<Contrat>();

}