package com.thomas.inmueble.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thomas.inmueble.modelo.Propietario;

public class RepositorioPropietario extends Repositorio<Propietario>{
	public Map<Integer,String> getMapOptions(){
		List<Propietario> l=get(Propietario.class);
		Map<Integer,String> m=new HashMap<Integer,String>();
		
		for(Propietario p:l){
			m.put(p.getIdPropietario(), p.getNombre());
		}
		return m;
	}

}
