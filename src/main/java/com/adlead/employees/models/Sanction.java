package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Sanction {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_sanction;
	private String libelle;
	
	@ManyToOne @Cascade(CascadeType.ALL)
	private Gravite gravite;
	
	@OneToMany(mappedBy = "sanction", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT) @JsonIgnore
	private List<SanctionToEmploye> employes = new ArrayList<SanctionToEmploye>();

}
