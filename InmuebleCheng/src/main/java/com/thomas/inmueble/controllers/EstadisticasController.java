package com.thomas.inmueble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
public class EstadisticasController {
	
	@Autowired
	RepositorioInmueble daoInm;
	
	@RequestMapping(value="/estadisticasInmuebles.html")
	public String listarInmuebles(Model m){
		
		List<Inmueble> l=daoInm.get(Inmueble.class);
		m.addAttribute("inmuebles",l);
		
		return "estadisticasInmuebles";
	}
	
}
