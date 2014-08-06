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

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.repositorios.RepositorioInmueble;

@Controller
@RequestMapping(value="/inmueble")
public class InmuebleResController {
	
	@Autowired
	RepositorioInmueble dao;
	
	/*function query*/
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Inmueble inmueble(@PathVariable int id){
		Inmueble i=dao.get(Inmueble.class, id);
		
		return i;
		
	}
	
	/*function list*/
	@RequestMapping(method=RequestMethod.GET, value="/buscar/{text}")
	public @ResponseBody List<Inmueble> buscar(@PathVariable String text){
		
		if(text.equals("????")){
			text="";
		}
		Map<String, Object> params=new HashMap();
		params.put("text", "%"+text+"%");
		List<Inmueble> l=dao.find("inmueble.buscador", params);
		return l;
	}
	
	/*function list*/
	@RequestMapping(method=RequestMethod.GET, value="/buscarPrecioMenor/{precio}")
	public @ResponseBody List<Inmueble> buscarPrecioMenor(@PathVariable Double precio){
		Map<String, Object> params=new HashMap();
		params.put("precio", precio);
		List<Inmueble> l=dao.find("inmueble.buscarPrecioMenor", params);
		return l;
	}
	
	/*function list*/
	@RequestMapping(method=RequestMethod.GET, value="/buscarPrecioMayor/{precio}")
	public @ResponseBody List<Inmueble> buscarPrecioMayor(@PathVariable Double precio){
		Map<String, Object> params=new HashMap();
		params.put("precio", precio);
		List<Inmueble> l=dao.find("inmueble.buscarPrecioMayor", params);
		return l;
	}
	
	/*function delete*/
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inmueble inmueble) {
		
		dao.delete(inmueble);
		
		return "inmueble borrado";
	}	
}
