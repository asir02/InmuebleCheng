package com.thomas.inmueble.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
public class PropietarioController {
	
	@Autowired
	RepositorioPropietario daoPropietario;
	
	@RequestMapping(value="/listarPropietarios.html")
	public String listarPropietarios(Model m){
		
		List<Propietario> l=daoPropietario.get(Propietario.class);
		m.addAttribute("propietarios",l);
		
		return "listarPropietarios";
	}
	
	@RequestMapping(value="detallePropietario.html", method=RequestMethod.GET)
	public String detallePropietario(Model m,HttpServletRequest req){
		
		int id=Integer.parseInt(req.getParameter("id"));
		Propietario p=daoPropietario.get(Propietario.class, id);
		
		m.addAttribute("propietario",p);
		
		return "detallePropietario";
	}

}