package com.adlead.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adlead.employees.models.AppRole;
import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.services.AccountServiceImpl;
import com.adlead.employees.services.AppRoleService;
import com.adlead.employees.services.UtilisateurService;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
  CommandLineRunner start(AccountServiceImpl accountService, AppRoleService appRoleService, UtilisateurService utilisateurService){
      return args -> {
          appRoleService.addNewRole(new AppRole("ADMIN"));
          appRoleService.addNewRole(new AppRole("SUPERUSER"));
          appRoleService.addNewRole(new AppRole("USER"));
          utilisateurService.addNewUser(new Utilisateur("admin", "admin"));
          utilisateurService.addNewUser(new Utilisateur("super", "super"));
          utilisateurService.addNewUser(new Utilisateur("user", "user"));
          accountService.affectRoleToUser("admin", "ADMIN");
          accountService.affectRoleToUser("super", "SUPERUSER");
          accountService.affectRoleToUser("user", "USER");
      };
  }

}
