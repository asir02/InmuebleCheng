package com.thomas.inmueble.modelo.viewforms;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.modelo.Propietario;

public class ViewInmueble {
	
	private Integer idInmueble;
    private Integer idInquilino;
    private Integer idPropietario;
    private String direccion;
    private double precio;
    
	public ViewInmueble() {
	}

	public ViewInmueble(Integer idInmueble,
			Integer idPropietario, String direccion, double precio) {
		super();
		this.idInmueble = idInmueble;
		this.idPropietario = idPropietario;
		this.direccion = direccion;
		this.precio = precio;
	}

	public ViewInmueble(Integer idInmueble, Integer idInquilino,
			Integer idPropietario, String direccion, double precio) {
		super();
		this.idInmueble = idInmueble;
		this.idInquilino = idInquilino;
		this.idPropietario = idPropietario;
		this.direccion = direccion;
		this.precio = precio;
	}
	
	public Inmueble getInmueble(){
		Inmueble i=new Inmueble();
		i.setIdInmueble(idInmueble);
		i.setDireccion(direccion);
		i.setPrecio(precio);
		
		Inquilino inq=new Inquilino();
		inq.setIdInquilino(idInquilino);
		i.setInquilino(inq);
		
		Propietario p=new Propietario();
		p.setIdPropietario(idPropietario);
		i.setPropietario(p);
		
		return i;
	}
	
	public void fromInmueble(Inmueble i) {
		setIdInmueble(i.getIdInmueble());
		setDireccion(i.getDireccion());
		setPrecio(i.getPrecio());
		
		setIdInquilino(i.getInquilino().getIdInquilino());
		setIdPropietario(i.getPropietario().getIdPropietario());
	}

	public Integer getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}

	public Integer getIdInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
    
	

}
