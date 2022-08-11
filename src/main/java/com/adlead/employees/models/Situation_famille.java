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
public class Situation_famille {

    /**
     * 
     */
	@Id @Column(length = 10)
    private String situation;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "situation_famille") @JsonIgnoreProperties("situation_famille")
    private List<Famille> familles = new ArrayList<Famille>();

}