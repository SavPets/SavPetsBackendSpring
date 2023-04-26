package com.fatec.scc.controller;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping
public class GUIDepartamentController {
    Logger logger = LogManager.getLogger(GUIAnimalCategoryController.class);
	@Autowired
	 // MantemCategoriaAnimal service;

	/* É necessário adicionar o objeto no modelAndView 
	 * para que possa utilizar os dados dele no frontend, 
	 * exemplo: na view de clientes, fazer um loop de todos os dados armazenados de clientes
	*/

	@GetMapping("/departamentos")
	public ModelAndView showCategoryAnimal() {
		ModelAndView modelAndView = new ModelAndView("departament/departament");
		
		return modelAndView;
	}

	@GetMapping("/criar-departamento")
    public ModelAndView showCreateAnimalCategory() {
		ModelAndView modelAndView = new ModelAndView("departament/CreateDepartament");
		

		return modelAndView;
    }


	@GetMapping("/atualizar-departamento")
    public ModelAndView showUpdateAnimalCategory() {
		ModelAndView modelAndView = new ModelAndView("departament/UpdateDepartament");
		

		return modelAndView;
    }
}