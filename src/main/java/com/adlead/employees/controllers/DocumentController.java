package com.adlead.employees.controllers;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adlead.employees.models.Document;
import com.adlead.employees.services.DocumentService;

@RestController
@RequestMapping("api/documents")
public class DocumentController {
	
	private DocumentService documentService;
	
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	@PostMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public Document save(@RequestParam("file") MultipartFile file, @RequestParam("description") String description, @PathVariable("id") long id) throws IOException{
		return this.documentService.save(file, description, id);
	}
	
	@GetMapping("/{employe}/{filename}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPERUSER')")
	public ResponseEntity<Resource> getFile(@PathVariable("filename") String filename, @PathVariable("employe") long employe) throws IOException{
		return this.documentService.download(filename, employe);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(@PathVariable("id") long id){
		this.documentService.delete(id);
	}
	

}
