package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="Medecin")
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long code_M;
	String nom_M;
	String prenom_M;
	String tel_M;
	
	
	
	

}
