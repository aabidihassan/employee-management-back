package com.adlead.employees.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Employe_Edit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_modification;
	
	private Date date_modification;
	
	@OneToOne @JsonIgnore
    private Employe employe;
    
    @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("employes_edition")
    private Utilisateur user;

}
