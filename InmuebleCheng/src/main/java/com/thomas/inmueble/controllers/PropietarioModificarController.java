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

import com.thomas.inmueble.modelo.Propietario;
import com.thomas.inmueble.modelo.viewforms.ViewPropietario;
import com.thomas.inmueble.repositorios.RepositorioInmueble;
import com.thomas.inmueble.repositorios.RepositorioInquilino;
import com.thomas.inmueble.repositorios.RepositorioPropietario;

@Controller
@RequestMapping(value="/modificarPropietario.html")
public class PropietarioModificarController {
	@Autowired
	RepositorioInmueble daoInmueble;
	@Autowired
	RepositorioInquilino daoInquilino;
	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap m,@PathVariable int id){
		
		Propietario p=daoPropietario.get(Propietario.class, id);
		ViewPropietario v=new ViewPropietario();
		v.fromPropietario(p);
		m.addAttribute("propietario",v);
		
		/*Map<Integer,String> inm=daoInmueble.getMapOptions();
		Map<Integer,String> inq=daoInquilino.getMapOptions();
		
		m.addAttribute("inmuebles",inm);
		m.addAttribute("inquilino",inq);*/
		
		return "modificarPropietario";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("propietario") 
		ViewPropietario v, 
		BindingResult res,
		HttpServletRequest req){
		
		if(res.hasErrors()){
			
			/*Map<Integer,String> inm=daoInmueble.getMapOptions();
			Map<Integer,String> inq=daoInquilino.getMapOptions();*/
			
			/*req.setAttribute("propietarios",inm);
			req.setAttribute("inquilinos",inq);*/
			
			return "modificarPropietario";			
		}
		
		Propietario p=v.getPropietario();
		daoPropietario.update(p);
		
		return "redirect:/listarPropietarios.html";		
	}

}
