package org.zixor.genesis.beans;

import java.io.Serializable;

public class Persona implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cedula;
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer value) {
		this.cedula = value;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private String nombre;
	Float estatura = 0.0f;
	
	public Float getEstatura() {
		return estatura;
	}
	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}
	public Persona() {
	
	}
	public Persona(Integer cedula, String nombre, float estatura) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.estatura = estatura;
	}
}
