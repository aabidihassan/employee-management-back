package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class Recrutement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_recrutement;
	
	private String date;
	
	@ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("recrutements")
	private Employe demendeur;
	
	@ManyToOne
	private Fonction fonction;
	
	private String contrat;

	@Column(nullable = true)
	private boolean statut;
	
	private String qualification;
	
	@ElementCollection(targetClass=String.class)
	private List<String> exigences = new ArrayList<String>();

}
