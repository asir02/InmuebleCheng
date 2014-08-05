package com.thomas.inmueble.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inquilino;
import com.thomas.inmueble.modelo.viewforms.ViewInquilino;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/altaInquilino.html")
public class InquilinoAltaController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String altaInquilino(ModelMap m){
		
		ViewInquilino v=new ViewInquilino();
		m.addAttribute("inquilino",v);
		
		/*Map<Integer,String> inm=daoInmueble.getMapOptions();
		
		m.addAttribute("inmuebles",inm);*/
		
		return "altaInquilino";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doAltaPropietario(@ModelAttribute("propietario") 
		ViewInquilino v, 
		BindingResult res,
		HttpServletRequest req
	){
		if(res.hasErrors()){
			
			/*Map<Integer,String> inm=daoInmueble.getMapOptions();*/
			
			/*req.setAttribute("inmuebles",inm);*/
			
			return "altaInquilino";			
		}
		
		Inquilino i=v.getInquilino();
		daoInquilino.add(i);
		
		return "redirect:/listarInquilinos.html";		
	}

}


