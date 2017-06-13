package com.tecsup.gestion.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Tienda;
import com.tecsup.gestion.model.Persona;
import com.tecsup.gestion.services.TiendaService;
import com.tecsup.gestion.services.PersonaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonaController {

	private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private PersonaService personaService;

	@Autowired
	private TiendaService tiendaService;
	
	@GetMapping("/user/menu")
	public String menu() {

		return "/user/menu";
	}
	
	@GetMapping("/user/403")
	public String accessDenied() {

		return "/user/403";
	}
	
	@GetMapping("/admin/per/list")
	public String list(@ModelAttribute("SpringWeb") Persona persona, ModelMap model) {

		try {
			model.addAttribute("personas", personaService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/per/list";
	}

	@GetMapping("/admin/per/{action}/{persona_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int persona_id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Persona per = personaService.find(persona_id);
			logger.info(per.toString());
			modelAndView = new ModelAndView("admin/per/" + action, "command", per);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/per/" + action, "command", new Persona());
		}

		return modelAndView;
	}

	@ModelAttribute("tiendaList")
	public Map<String, String> getCountryList() {
		
		Map<String, String> tiendaList = new HashMap<String, String>();
		tiendaList.put("0","--");
		
		try {
			List<Tienda> tndas = tiendaService.findAll();
			
			for (Tienda tnda : tndas)
				tiendaList.put(""+tnda.getTiendaId(), tnda.getName());

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tiendaList;
	}	
	
	
	@PostMapping("/admin/per/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Persona per, ModelMap model) {

		ModelAndView modelAndView = null;

		logger.info(per.toString());
		
		try {
			personaService.update(per.getPersonaId(), per.getPassword(), per.getFirstname(),
					per.getCorreo(), per.getTienda().getTiendaId());

			modelAndView = new ModelAndView("redirect:/admin/per/list");
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();		
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		}

		return modelAndView;
	}

	@PostMapping("/admin/per/delete")
	public ModelAndView delete(@ModelAttribute("SpringWeb") Persona per, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			personaService.delete(per.getPersonaId());
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		}

		return modelAndView;
	}

	@GetMapping("/admin/per/createform")
	public ModelAndView createform() {

		Persona per = new Persona();

		ModelAndView modelAndView = new ModelAndView("admin/per/createform", "command", per);

		return modelAndView;
	}

	@PostMapping("/admin/per/create")
	public ModelAndView create(@ModelAttribute("SpringWeb") Persona per, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			int perId = personaService.create(per.getLogin(), per.getPassword(), per.getFirstname(), 
					per.getCorreo(), per.getTienda().getTiendaId());
			logger.info( "new Persona ID = " + perId);
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		}

		return modelAndView;
	}
	
	
	@GetMapping("/admin/per/rol/createform")
	public ModelAndView createformWithRole() {

		Persona per = new Persona();

		ModelAndView modelAndView = new ModelAndView("admin/per/rol/createform", "command", per);

		return modelAndView;
	}

	@PostMapping("/admin/per/rol/create")
	public ModelAndView createWithRole(@ModelAttribute("SpringWeb") Persona per, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			int perId = personaService.createWithRole(per.getLogin(), per.getPassword(), per.getFirstname(), 
					per.getCorreo(), per.getTienda().getTiendaId(), per.getRole().getRoleId());
			logger.info( "new Persona ID = " + perId);
			modelAndView = new ModelAndView("redirect:/admin/per/list");
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/per/rol/createform", "command", per);
		}

		return modelAndView;
	}
}
