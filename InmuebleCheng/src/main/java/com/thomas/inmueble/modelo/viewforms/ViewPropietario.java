package com.thomas.inmueble.modelo.viewforms;

import com.thomas.inmueble.modelo.Propietario;

public class ViewPropietario {


    private Integer idPropietario;
    private String nombre;
    private String dni; 
    
    
	public ViewPropietario() {
	}

	public ViewPropietario(Integer idPropietario, String nombre, String dni) {
		super();
		this.idPropietario = idPropietario;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public Propietario getPropietario(){
		Propietario p=new Propietario();
		p.setIdPropietario(idPropietario);
		p.setNombre(nombre);
		p.setDni(dni);
		
		return p;
	}
	
	public void fromPropietario(Propietario p) {
		setIdPropietario(p.getIdPropietario());
		setNombre(p.getNombre());
		setDni(p.getDni());
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
    
    

}
