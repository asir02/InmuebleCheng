package com.thomas.inmueble.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.modelo.viewforms.ViewPropietario;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/altaPropietario.html")
public class PropietarioAltaController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String altaPropietario(ModelMap m){
		
		ViewPropietario v=new ViewPropietario();
		m.addAttribute("propietario",v);
		
		/*Map<Integer,String> inm=daoInmueble.getMapOptions();
		
		m.addAttribute("inmuebles",inm);*/
		
		return "altaPropietario";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doAltaPropietario(@ModelAttribute("propietario") 
		ViewPropietario v, 
		BindingResult res,
		HttpServletRequest req
	){
		if(res.hasErrors()){
			
			/*Map<Integer,String> inm=daoInmueble.getMapOptions();*/
			
			/*req.setAttribute("inmuebles",inm);*/
			
			return "altaPropietario";			
		}
		
		Propietario p=v.getPropietario();
		daoPropietario.add(p);
		
		return "redirect:/listarPropietarios.html";		
	}

}
