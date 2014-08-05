package com.thomas.inmueble.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thomas.inmueble.modelo.Inquilino;

public class RepositorioInquilino extends Repositorio<Inquilino>{
	public Map<Integer,String> getMapOptions(){
		List<Inquilino> l=get(Inquilino.class);
		Map<Integer,String> m=new HashMap<Integer,String>();
		
		for(Inquilino i:l){
			m.put(i.getIdInquilino(), i.getNombre());
		}
		return m;
	}

}
