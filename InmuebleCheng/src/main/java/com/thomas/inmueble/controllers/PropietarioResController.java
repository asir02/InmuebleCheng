package com.thomas.inmueble.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/propietario")
public class PropietarioResController {
	
	@Autowired
	RepositorioPropietario dao;
	
	/*function query*/
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Propietario propietario(@PathVariable int id){
		Propietario p=dao.get(Propietario.class, id);
		
		return p;
		
	}
	
	/*function list*/
	@RequestMapping(method=RequestMethod.GET, value="/buscar/{text}")
	public @ResponseBody List<Propietario> buscar(@PathVariable String text){
		
		if(text.equals("????")){
			text="";
		}
		Map<String, Object> params=new HashMap();
		params.put("text", "%"+text+"%");
		List<Propietario> l=dao.find("propietario.buscador", params);
		return l;
	}
	
	/*function delete*/
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Propietario p) {
		
		dao.delete(p);
		
		return "propietario borrado";
	}

}
