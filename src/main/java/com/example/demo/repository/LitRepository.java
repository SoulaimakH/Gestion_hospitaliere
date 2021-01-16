package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.EtatLit;
import com.example.demo.models.Lit;
import com.example.demo.models.Patient;





public interface LitRepository extends JpaRepository<Lit, Long> {
	List<Lit> findAllByEtat(EtatLit e);
	
	
}
