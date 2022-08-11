package com.adlead.employees.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

    @Id
    @Column(length = 30)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany @JsonIgnoreProperties("users")
    List<AppRole> roles = new ArrayList<>();
    
    @ManyToMany @JsonIgnoreProperties("user")
    List<Acces> acces = new ArrayList<Acces>();
    
    public Utilisateur(String username, String password){
    	this.username = username;
    	this.password = password;
    }
}
