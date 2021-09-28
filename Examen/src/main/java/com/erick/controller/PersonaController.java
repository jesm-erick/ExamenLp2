package com.erick.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erick.interfaces.iservice.IpersonaService;
import com.erick.models.Persona;


@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String Listar(Model model) {
		List<Persona> personas =service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "persona_add";
	}
	@GetMapping("/save")
	public String guardar (@Validated Persona per, Model model) {
		service.guardar(per);
		return "redirect:/listar";
		
	}
	@GetMapping("/editar/{id}")
    public String editar(@PathVariable int id,Model model) {
        Optional<Persona> persona=service.listarId(id);
        model.addAttribute("persona",persona);
        return "persona_add";
    }
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable int id, Model model) {
		service.eliminar(id);
		return "redirect:/listar";
	}
}

