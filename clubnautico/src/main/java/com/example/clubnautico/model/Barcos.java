package com.example.clubnautico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "barcos")
public class Barcos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_barco;
    
    private int numero_matricula;
    private String nombre;
    private int numero_amarre;
    private double cuota;

    // ID del socio en la tabla de Barcos
    @ManyToOne
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    private Socio id_socio;

	public int getId_barco() {
		return id_barco;
	}

	public void setId_barco(int id_barco) {
		this.id_barco = id_barco;
	}

	public int getNumero_matricula() {
		return numero_matricula;
	}

	public void setNumero_matricula(int numero_matricula) {
		this.numero_matricula = numero_matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero_amarre() {
		return numero_amarre;
	}

	public void setNumero_amarre(int numero_amarre) {
		this.numero_amarre = numero_amarre;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public Socio getId_socio() {
		return id_socio;
	}

	public void setId_socio(Socio id_socio) {
		this.id_socio = id_socio;
	}
	
    
}