package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "chambre")
public class Chambre implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
	private int etage;
	private int nbrlit;
	
	@OneToMany(mappedBy="chambre")
    private Set<Lit> lits;


}
