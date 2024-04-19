package com.example.clubnautico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "socios")
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dni_socio;
	private String nom_socio;
	private String tlf_socio;
	private String dir_socio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni_socio() {
		return dni_socio;
	}

	public void setDni_socio(String dni_socio) {
		this.dni_socio = dni_socio;
	}

	public String getNom_socio() {
		return nom_socio;
	}

	public void setNom_socio(String nom_socio) {
		this.nom_socio = nom_socio;
	}

	public String getTlf_socio() {
		return tlf_socio;
	}

	public void setTlf_socio(String tlf_socio) {
		this.tlf_socio = tlf_socio;
	}

	public String getDir_socio() {
		return dir_socio;
	}

	public void setDir_socio(String dir_socio) {
		this.dir_socio = dir_socio;
	}

}
