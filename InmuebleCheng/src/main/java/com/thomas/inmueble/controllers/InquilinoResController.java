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

import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/inquilino")
public class InquilinoResController {
	
	@Autowired
	RepositorioInquilino dao;
	
	/*function query*/
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Inquilino inquilino(@PathVariable int id){
		Inquilino i=dao.get(Inquilino.class, id);
		
		return i;
		
	}
	
	/*function list*/
	@RequestMapping(method=RequestMethod.GET, value="/buscar/{text}")
	public @ResponseBody List<Inquilino> buscar(@PathVariable String text){
		
		if(text.equals("????")){
			text="";
		}
		Map<String, Object> params=new HashMap();
		params.put("text", "%"+text+"%");
		List<Inquilino> l=dao.find("inquilino.buscador", params);
		return l;
	}
	
	/*function delete*/
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino i) {
		
		dao.delete(i);
		
		return "inquilino borrado";
	}

}
