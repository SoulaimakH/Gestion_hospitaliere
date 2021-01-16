package com.example.demo.models;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EtatLit etat;
	private long numch;
	private String description;
	@ManyToOne
    @JoinColumn(name="chambre_id", nullable=true)
	private Chambre cham;
	private Long pid;
	@OneToOne
	@JoinColumn( name="id_patient", nullable=true )
	private Patient patient;
}
