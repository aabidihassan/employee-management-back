package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Enquette {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_enquette;
	
	@ManyToMany(mappedBy = "enquettes", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Question> questions = new ArrayList<Question>();
	
}
