package com.thomas.inmueble.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.repositorios.RepositorioInmueble;

@Controller
public class InmuebleController {
	
	@Autowired
	RepositorioInmueble daoInmueble;
	
	@RequestMapping(value="/listarInmuebles.html")
	public String listarInmuebles(Model m){
		
		List<Inmueble> l=daoInmueble.get(Inmueble.class);
		m.addAttribute("inmuebles",l);
		
		return "listarInmuebles";
	}
	
	@RequestMapping(value="/detalleInmueble.html", method=RequestMethod.GET)
	public String detalleInmueble(Model m,HttpServletRequest req){
		
		int id=Integer.parseInt(req.getParameter("id"));
		Inmueble i=daoInmueble.get(Inmueble.class, id);
		
		m.addAttribute("inmueble",i);
		
		return "detalleInmueble";
	}

}
