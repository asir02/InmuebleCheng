package com.thomas.inmueble.modelo.viewforms;

import java.util.HashSet;
import java.util.Set;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.modelo.Propietario;

public class ViewInquilino {
	
	private Integer idInquilino;
    private String dni;
    private String nombre;
    private int edad;
    private Boolean trabaja;  
    
    
	public ViewInquilino() {
	}

	public ViewInquilino(Integer idInquilino, String dni, String nombre,
			int edad, Boolean trabaja) {
		super();
		this.idInquilino = idInquilino;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.trabaja = trabaja;
	}
	
	public Inquilino getInquilino(){
		Inquilino i=new Inquilino();
		i.setIdInquilino(idInquilino);
		i.setDni(dni);
		i.setNombre(nombre);
		i.setEdad(edad);
		i.setTrabaja(trabaja);
		
		return i;
	}
	
	public void fromInquilino(Inquilino i) {
		setIdInquilino(i.getIdInquilino());
		setDni(i.getDni());
		setNombre(i.getNombre());
		setEdad(i.getEdad());
		setTrabaja(i.getTrabaja());
	}

	public Integer getIdInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Boolean getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(Boolean trabaja) {
		this.trabaja = trabaja;
	}
    
    

}
