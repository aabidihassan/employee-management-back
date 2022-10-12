package com.adlead.employees.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.adlead.employees.models.Document;
import com.adlead.employees.models.Employe;
import com.adlead.employees.repositories.DocumentRepo;

@Service
public class DocumentService {
	
	private DocumentRepo documentRepo;
	private EmployeService employeService;
	public static final String DIRECTORY = "src/main/resources/templates/files/";
	
	@Value("${upload.path}")
    private String uploadPath;
	
	@Autowired
	public DocumentService(DocumentRepo documentRepo, EmployeService employeService) {
		this.documentRepo = documentRepo;
		this.employeService = employeService;
	}
	
	public Document save(MultipartFile file, String description, long id) throws IOException {
		Employe emp = this.employeService.getById(id);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File directory = new File(DIRECTORY + emp.getId_employe() + "/");
		if (! directory.exists()) directory.mkdir();
		Path filestorage = Paths.get(DIRECTORY + emp.getId_employe() + "/", filename).toAbsolutePath().normalize();
		Files.copy(file.getInputStream(), filestorage);
		Document document = new Document();
		document.setFichier(emp.getId_employe() + "/" + filename);
		document.setEmploye(emp);
		document.setDescription(description);
		return this.documentRepo.save(document);
	}
	
	public ResponseEntity<Resource> download(String filename, long employe) throws IOException{
		Path filepath = Paths.get(DIRECTORY + employe + "/").toAbsolutePath().normalize().resolve(filename);
		if(!Files.exists(filepath)) throw new FileNotFoundException("Le fichier n'est pas trouve");
		Resource resource = new UrlResource(filepath.toUri());
		HttpHeaders headers = new HttpHeaders();
		headers.add("File-Name", filename);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachement;File-Name="+resource.getFilename());
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filepath)))
				.headers(headers).body(resource);
	}
	
	public Document getById(long id) {
		return this.documentRepo.findById(id).get();
	}
	
	public void delete(long id) {
		Document doc = this.getById(id);
		File file = new File(DIRECTORY+ doc.getFichier());
		file.delete();
		this.documentRepo.deleteById(id);
		
	}

}
