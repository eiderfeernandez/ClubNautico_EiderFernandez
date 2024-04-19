package com.example.clubnautico.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clubnautico.model.Socio;

public interface SociosRepository extends JpaRepository<Socio, Integer>{
	
}
