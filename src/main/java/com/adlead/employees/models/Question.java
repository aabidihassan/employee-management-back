package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Question {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_question;
	
	private String question;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Reponse> reponses = new ArrayList<Reponse>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT) @JsonIgnore
	private List<Enquette> enquettes = new ArrayList<Enquette>();

}
