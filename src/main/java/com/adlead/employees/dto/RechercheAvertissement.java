package com.adlead.employees.dto;

import com.adlead.employees.models.Employe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RechercheAvertissement {
	
	private String de;
	private String jusqua;
	private Employe employe;

}
