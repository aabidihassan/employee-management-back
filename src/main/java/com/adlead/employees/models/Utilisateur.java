package com.adlead.employees.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) @JsonIgnoreProperties("users")
    @Cascade(CascadeType.ALL)
    List<AppRole> roles = new ArrayList<>();
    
    @OneToMany(mappedBy = "user") @JsonIgnore
    List<Employe_Creation> employes_creation = new ArrayList<Employe_Creation>();
    
    @OneToMany(mappedBy = "user") @JsonIgnore
    List<Employe_Edit> employes_edition = new ArrayList<Employe_Edit>();
    
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER) @JsonIgnore
    private Employe employe;
    
    
    public Utilisateur(String username, String password){
    	this.username = username;
    	this.password = password;
    }
}
