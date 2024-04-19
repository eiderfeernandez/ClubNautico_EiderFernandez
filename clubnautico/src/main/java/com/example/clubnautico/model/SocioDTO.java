package com.example.clubnautico.model;

import jakarta.validation.constraints.NotEmpty;

public class SocioDTO {
	
	@NotEmpty(message="DNI obligatorio")
	private String dni_socio;
	
	@NotEmpty(message="Nombre obligatorio")
	private String nom_socio;
	
	@NotEmpty(message="Teléfono obligatorio")
	private String tlf_socio;
	
	@NotEmpty(message="Dirección obligatoria")
	private String dir_socio;
	
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
