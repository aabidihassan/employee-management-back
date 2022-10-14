package com.adlead.employees.dto;

import org.springframework.web.multipart.MultipartFile;

import com.adlead.employees.models.Employe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class EmployeDto {
	
	private Employe employe;
	private MultipartFile photo;

}
