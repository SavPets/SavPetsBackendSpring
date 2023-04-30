package com.fatec.scc.controller.animalReport;

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

import com.fatec.scc.model.animalReport.*;
import com.fatec.scc.services.MantemRelatorioAnimal;

@Controller
@RequestMapping

public class GUIRelatorioAnimalController {
	Logger logger = LogManager.getLogger(GUIRelatorioAnimalController.class);
	@Autowired
	MantemRelatorioAnimal service;

	@GetMapping("/relatorios-animais")
	public ModelAndView showRelatorioAnimal(RelatorioAnimal relatorioAnimal) {
		ModelAndView modelAndView = new ModelAndView("animalReport/animalReport");
		modelAndView.addObject("categoriasAnimais", service.searchAll());

		return modelAndView;
	}

	@GetMapping("/criar-relatorio-animal")
    public ModelAndView showCreateRelatorioAnimal(RelatorioAnimal relatorioAnimal) {
		ModelAndView modelAndView = new ModelAndView("animalReport/CreateAnimalReport");
		modelAndView.addObject("categoriaAnimal", relatorioAnimal);

		return modelAndView;
    }

    @PostMapping("/criar-relatorio-animal")
	public RedirectView createRelatorioAnimal(@Valid RelatorioAnimal relatorioAnimal, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/criar-relatorio-animal?status=Erro&text=Revise_os_campos_do_registro!");
		}

		if (!service.save(relatorioAnimal).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("animalCategory/CreateAnimalCategory");
			modelAndView.addObject("message", "Dados invalidos");
		}

		return new RedirectView("/relatorios-animais?status=Cadastrado");
	}

	@GetMapping("/atualizar-relatorio-animal/{id}")
    public ModelAndView showUpdateAnimalCategory(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("animalCategory/UpdateAnimalCategory");
		modelAndView.addObject("categoriaAnimal", service.searchById(id).get());

		return modelAndView;
    }

	@PostMapping("/atualizar-relatorio-animal/{id}")
	public RedirectView updateAnimalCategory(@PathVariable("id") Long id, @Valid RelatorioAnimal relatorioAnimal, BindingResult result) {
		if (result.hasErrors()) {
			relatorioAnimal.setId(id);
			
			return new RedirectView("/atualizar-relatorio-animal/{id}?status=Erro&text=Revise_os_campos_do_registro!");
		}
		service.updates(id, relatorioAnimal);
				
		return new RedirectView("/relatorios-animais?status=Atualizado");
	}

	@GetMapping("/deletar-relatorio-animal/{id}")
	public RedirectView deleteAnimalCategory(@PathVariable("id") Long id) {
		service.delete(id);
		return new RedirectView("/relatorios-animais");
}
}