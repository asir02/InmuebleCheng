package com.thomas.inmueble.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Inmueble;
import com.thomas.inmueble.modelo.viewforms.ViewInmueble;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/modificarInmueble.html")
public class InmuebleModificarController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap m,@PathVariable int id){
		
		Inmueble i=daoInmueble.get(Inmueble.class, id);
		ViewInmueble vi=new ViewInmueble();
		vi.fromInmueble(i);
		m.addAttribute("inmueble",vi);
		
		Map<Integer,String> mp=daoPropietario.getMapOptions();
		Map<Integer,String> mi=daoInquilino.getMapOptions();
		
		m.addAttribute("propietarios",mp);
		m.addAttribute("inquilinos",mi);
		
		return "modificarInmueble";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inmueble") 
		ViewInmueble vi, 
		BindingResult res,
		HttpServletRequest req){
		
		if(res.hasErrors()){
			
			Map<Integer,String> mp=daoPropietario.getMapOptions();
			Map<Integer,String> mi=daoInquilino.getMapOptions();
			
			req.setAttribute("propietarios",mp);
			req.setAttribute("inquilinos",mi);
			
			return "modificarInmueble";			
		}
		
		Inmueble i=vi.getInmueble();
		daoInmueble.update(i);
		
		return "redirect:/listarInmuebles.html";		
	}

}
