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
	int Id_P;
	String Nom_P;
	String Prenom_P;
	int age_P;
	String adresse_P;
	@OneToOne
	@JoinColumn( name="id_Lit", nullable=false )
	private Lit lit;
	
	

}
