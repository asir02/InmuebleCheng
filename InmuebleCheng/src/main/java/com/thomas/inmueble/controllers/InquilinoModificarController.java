package com.thomas.inmueble.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.modelo.viewforms.ViewInquilino;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/modificarInquilino.html")
public class InquilinoModificarController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap m,@PathVariable int id){
		
		Inquilino i=daoInquilino.get(Inquilino.class, id);
		ViewInquilino v=new ViewInquilino();
		v.fromInquilino(i);
		m.addAttribute("inquilino",v);
		
		return "modificarInquilino";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inquilino") 
		ViewInquilino v, 
		BindingResult res,
		HttpServletRequest req){
		
		if(res.hasErrors()){
			
			return "modificarInquilino";			
		}
		
		Inquilino i=v.getInquilino();
		daoInquilino.update(i);
		
		return "redirect:/listarInquilinos.html";		
	}

}