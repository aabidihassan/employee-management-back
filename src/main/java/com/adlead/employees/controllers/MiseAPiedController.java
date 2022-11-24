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

import com.adlead.employees.dto.RechercheAvertissement;
import com.adlead.employees.models.MiseAPied;
import com.adlead.employees.services.MiseAPiedService;

@RestController
@RequestMapping("api/miseapieds")
public class MiseAPiedController {
	
	private MiseAPiedService miseAPiedService;
	
	@Autowired
	public MiseAPiedController(MiseAPiedService miseAPiedService) {
		this.miseAPiedService = miseAPiedService;
	}
	
	@PostMapping("/")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public MiseAPied save(@RequestBody MiseAPied miseAPied){
        return this.miseAPiedService.save(miseAPied);
    }
	
	@PostMapping("/search")
    @PostAuthorize("hasAnyAuthority('ADMIN', 'SUPERUSER')")
    public List<MiseAPied> findByCritiques(@RequestBody RechercheAvertissement rechercheAvertissement){
        return this.miseAPiedService.getMiseAPiedByCritiques(rechercheAvertissement);
    }
	
	@GetMapping("/{id}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable(name="id") long id){
        this.miseAPiedService.delete(id);
    }

}
