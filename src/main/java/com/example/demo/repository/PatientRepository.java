package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Lit;
import com.example.demo.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByNumlit(long id);
}
