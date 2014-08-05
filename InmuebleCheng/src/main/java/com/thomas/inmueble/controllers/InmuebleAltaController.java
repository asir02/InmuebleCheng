package com.thomas.inmueble.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.modelo.viewforms.ViewInmueble;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/altaInmueble.html")
public class InmuebleAltaController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String altaInmueble(ModelMap m){
		
		ViewInmueble vi=new ViewInmueble();
		m.addAttribute("inmueble",vi);
		
		Map<Integer,String> mp=daoPropietario.getMapOptions();
		Map<Integer,String> mi=daoInquilino.getMapOptions();
		
		m.addAttribute("propietarios",mp);
		m.addAttribute("inquilinos",mi);
		
		return "altaInmueble";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doAltaInmueble(@ModelAttribute("inmueble") 
		ViewInmueble vi, 
		BindingResult res,
		HttpServletRequest req
	){
		if(res.hasErrors()){
			
			Map<Integer,String> mp=daoPropietario.getMapOptions();
			Map<Integer,String> mi=daoInquilino.getMapOptions();
			
			req.setAttribute("propietarios",mp);
			req.setAttribute("inquilinos",mi);
			
			return "altaInmueble";			
		}
		
		Inmueble i=vi.getInmueble();
		daoInmueble.add(i);
		
		return "redirect:/listarInmuebles.html";		
	}

}
