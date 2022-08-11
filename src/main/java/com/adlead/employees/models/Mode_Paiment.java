package com.adlead.employees.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Mode_Paiment {

    /**
     * 
     */
	@Id @Column(length = 10)
    private String mode;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mode_paiment") @JsonIgnoreProperties("mode_paiment")
    private List<Detail_RH> demandes = new ArrayList<Detail_RH>();

}