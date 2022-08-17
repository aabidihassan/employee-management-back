package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Employe {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_employe;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String telephone;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String naissance;

    /**
     * 
     */
    private String photo;

    /**
     * 
     */
    private String cin;

    /**
     * 
     */
    private String matricule;

    /**
     * 
     */
    private String adresse;
    
    @ManyToOne @JsonIgnoreProperties("employes")
    private Statut statut;
    
    @OneToOne @JsonIgnoreProperties("employes")
    private Detail_RH detailsRH;
    
    @OneToOne @JsonIgnoreProperties("employe")
    private Famille famille;
    
    @OneToOne @JsonIgnoreProperties("employe")
    private Acces acces;
    
    @OneToOne @JsonIgnoreProperties("employe")
    private Fonction fonction;
    
    @OneToMany(mappedBy = "employe") @JsonIgnoreProperties("employe")
    private List<Contrat> contrats = new ArrayList<Contrat>();
    
    @OneToMany(mappedBy = "employe") @JsonIgnoreProperties("employe")
    private List<Demande_Conge> demandes = new ArrayList<Demande_Conge>();
    
    @OneToMany(mappedBy = "employe") @JsonIgnoreProperties("employe")
    private List<Document> documents = new ArrayList<Document>();
    
    @OneToMany(mappedBy = "employe") @JsonIgnoreProperties("employe")
    private List<Champs_CV> champs = new ArrayList<Champs_CV>();

}