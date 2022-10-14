package com.adlead.employees.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppFile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_file;
	private String name;
	private String extension;
	@Lob
	private byte[] data;

}
