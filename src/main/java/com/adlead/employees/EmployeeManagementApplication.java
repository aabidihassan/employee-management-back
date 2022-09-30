package com.adlead.employees;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.adlead.employees.models.AppRole;
import com.adlead.employees.models.Employe;
import com.adlead.employees.models.Employe_Creation;
import com.adlead.employees.models.Service;
import com.adlead.employees.models.Statut;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.services.AccountServiceImpl;
import com.adlead.employees.services.AppRoleService;
import com.adlead.employees.services.ServiceService;
import com.adlead.employees.services.UtilisateurService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@CrossOrigin("*")
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.adlead.employees.controllers")).build();
	   }
	
//	@Bean
//  CommandLineRunner start(AccountServiceImpl accountService, AppRoleService appRoleService, UtilisateurService utilisateurService, ServiceService serviceService){
//      return args -> {
//          appRoleService.addNewRole(new AppRole("ADMIN"));
//          appRoleService.addNewRole(new AppRole("SUPERUSER"));
//          appRoleService.addNewRole(new AppRole("USER"));
//          Utilisateur user1 = new Utilisateur();
//          user1.setId_user(0);
//          user1.setUsername("admin");
//          user1.setPassword("admin");
//          user1.setEmploye(new Employe(0, "Admin", "Admin", "aabidihassan2@gmail.com", "0637842698",
//        		  "M", "23/10/2000", "Photo url", "EE869060", "emp0001", true, "455 izdihar 2 Marrakech", new Statut("Actif", null), null, null, null, null, null, null, null, null, null, null));
//          utilisateurService.addNewUser(user1);
////          utilisateurService.addNewUser(new Utilisateur("super", "super"));
////          utilisateurService.addNewUser(new Utilisateur("user", "user"));
//          accountService.affectRoleToUser("admin", "ADMIN");
////          accountService.affectRoleToUser("super", "SUPERUSER");
////          accountService.affectRoleToUser("user", "USER");
//      };
//  }

}
