package com.tecsup.gestion.control;

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

import com.tecsup.gestion.model.Tienda;
import com.tecsup.gestion.services.TiendaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TiendaController {

	private static final Logger logger = LoggerFactory.getLogger(TiendaController.class);

	@Autowired
	private TiendaService tiendaService;

	
	@GetMapping("/admin/tnda/list")
	public String list(@ModelAttribute("SpringWeb") Tienda tienda, ModelMap model) {

		try {
			model.addAttribute("tiendas", tiendaService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/tnda/list";
	}

	@GetMapping("/admin/tnda/{action}/{tienda_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int tienda_id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Tienda tnda = tiendaService.findById(tienda_id);
			logger.info(tnda.toString());
			modelAndView = new ModelAndView("admin/tnda/" + action, "command", tnda);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/tnda/" + action, "command", new Tienda());
		}

		return modelAndView;
	}

	@PostMapping("/admin/tnda/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Tienda tnda, ModelMap model) {
	
		ModelAndView modelAndView = null;
		logger.info("editsave() = "+tnda.toString());
		try {
			tiendaService.update(tnda.getTiendaId(), tnda.getName(), tnda.getDescription());
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		}

		return modelAndView;
	}

	@PostMapping("/admin/tnda/delete")
	public ModelAndView delete(@ModelAttribute("SpringWeb") Tienda tnda, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			tiendaService.delete(tnda.getTiendaId());
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		}

		return modelAndView;
	}

	@GetMapping("/admin/tnda/createform")
	public ModelAndView createform() {
		logger.info( "createform() ");
		Tienda tnda = new Tienda();

		ModelAndView modelAndView = new ModelAndView("admin/tnda/createform", "command", tnda);

		return modelAndView;
	}

	@PostMapping("/admin/tnda/create")
	public ModelAndView createdpto(@ModelAttribute("SpringWeb") Tienda tnda, ModelMap model) {
		logger.info( "create() ");
		ModelAndView modelAndView = null;

		try {
			
			int tndaId = tiendaService.create(tnda.getName(), tnda.getDescription());
			logger.info( "new Tienda ID = " + tndaId);
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/tnda/list");
		}

		return modelAndView;
	}
}
