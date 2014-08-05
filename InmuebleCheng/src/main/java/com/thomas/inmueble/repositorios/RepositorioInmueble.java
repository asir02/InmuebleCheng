package com.thomas.inmueble.repositorios;

import org.hibernate.Hibernate;
import com.thomas.inmueble.modelo.Inmueble;

public class RepositorioInmueble extends Repositorio<Inmueble>{
	
	@Override
	public Inmueble get(Class<Inmueble> c,int id){
		
		Inmueble i=super.get(c, id);
		
		Hibernate.initialize(i.getInquilino());
		Hibernate.initialize(i.getPropietario());
		
		return i;
		
	}

}
