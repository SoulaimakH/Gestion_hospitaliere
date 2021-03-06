package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long idp;
	String nomp;
	String prenomp;
	String sexe;
	int agep;
	String adressep;
	int sejour;
	long numlit ;
	
	@OneToOne(mappedBy="patient")
	private Lit lit;
	
	
	

}
