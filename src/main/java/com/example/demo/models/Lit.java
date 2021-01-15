package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;
@Entity
@Data
@Table(name = "lit")
public class Lit implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
	private float prix;
	private EtatLit etat;
	private String Description;
	@ManyToOne
    @JoinColumn(name="chambre_id", nullable=false)
	private Chambre chambre;
	
	@OneToOne(mappedBy="lit")
	private Patient patient;
}
