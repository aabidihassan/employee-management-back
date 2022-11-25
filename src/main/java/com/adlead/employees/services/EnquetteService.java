package com.adlead.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlead.employees.models.Enquette;
import com.adlead.employees.repositories.EnquetteRepo;

@Service
public class EnquetteService {
	
	private EnquetteRepo enquetteRepo;
	private ReponseService reponseService;
	
	@Autowired
	public EnquetteService(EnquetteRepo enquetteRepo, ReponseService reponseService) {
		this.enquetteRepo = enquetteRepo;
		this.reponseService = reponseService;
	}
	
	public Enquette save(Enquette enquette) {
		return this.enquetteRepo.save(enquette);
	}
	
	public List<Enquette> getAll(){
		List<Enquette> list = this.enquetteRepo.findAll();
		list.forEach(enquette->{
			enquette.getQuestions().forEach(question->{
				question.setReponses(this.reponseService.getAllByEnquette(enquette));
			});
		});
		return list;
	}

}
