package com.thomas.inmueble.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.repositorios.RepositorioInquilino;

@Controller
public class InquilinoController {
	
	@Autowired
	RepositorioInquilino daoInquilino;
	
	@RequestMapping(value="/listarInquilinos.html")
	public String listarInquilinos(Model m){
		
		List<Inquilino> l=daoInquilino.get(Inquilino.class);
		m.addAttribute("inquilinos",l);
		
		return "listarInquilinos";
	}
	
	@RequestMapping(value="detalleInquilino.html", method=RequestMethod.GET)
	public String detalleInquilino(Model m,HttpServletRequest req){
		
		int id=Integer.parseInt(req.getParameter("id"));
		Inquilino i=daoInquilino.get(Inquilino.class, id);
		
		m.addAttribute("inquilino",i);
		
		return "detalleInquilino";
	}

}