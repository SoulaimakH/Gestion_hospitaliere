package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Chambre;


public interface ChambreRepository extends JpaRepository<Chambre, Long> {

}
