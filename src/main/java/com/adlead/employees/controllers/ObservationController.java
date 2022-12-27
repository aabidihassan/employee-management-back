package com.adlead.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adlead.employees.dto.RechercheDto;
import com.adlead.employees.models.Observation;
import com.adlead.employees.services.ObservationService;

@RestController
@RequestMapping("api/observations")
public class ObservationController {
	
	private ObservationService observationService;
	
	@Autowired
	public ObservationController(ObservationService observationService) {
		this.observationService = observationService;
	}
	
	@PostMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public Observation save(@RequestBody Observation observation){
        return this.observationService.save(observation);
    }
	
	@PostMapping("/search")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<Observation> findByCritiques(@RequestBody RechercheDto rechercheAvertissement){
        return this.observationService.getObservationByCritiques(rechercheAvertissement);
    }
	
	@GetMapping("/{id}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable(name="id") long id){
        this.observationService.delete(id);
    }

}
