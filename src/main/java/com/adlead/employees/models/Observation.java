package com.adlead.employees.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Observation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_observation;
	
	private String date;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("observations")
	private Employe employe;

}
