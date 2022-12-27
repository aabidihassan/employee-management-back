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
import com.adlead.employees.models.SanctionToEmploye;
import com.adlead.employees.services.SanctionToEmployeService;

@RestController
@RequestMapping("api/sanctions/affectation")
public class SanctionToEmployeController {
	
	private SanctionToEmployeService sanctionToEmployeService;
	
	@Autowired
	public SanctionToEmployeController(SanctionToEmployeService sanctionToEmployeService) {
		this.sanctionToEmployeService = sanctionToEmployeService;
	}
	
	@PostMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public SanctionToEmploye save(@RequestBody SanctionToEmploye sanction){
        return this.sanctionToEmployeService.save(sanction);
    }
	
	@GetMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<SanctionToEmploye> getAll(){
        return this.sanctionToEmployeService.getAll();
    }
	
	@PostMapping("/search")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<SanctionToEmploye> findByCritiques(@RequestBody RechercheDto rechercheAvertissement){
        return this.sanctionToEmployeService.getSanctionsByCritiques(rechercheAvertissement);
    }
	
	@GetMapping("/{id}")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public void delete(@PathVariable(name = "id") long id){
        this.sanctionToEmployeService.delete(id);
    }

}
