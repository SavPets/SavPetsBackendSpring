package com.fatec.scc.controller.animalCategory;

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

import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;
import com.fatec.scc.services.categoriaAnimal.MantemCategoriaAnimal;

@Controller
@RequestMapping
public class GUIAnimalCategoryController {
    Logger logger = LogManager.getLogger(GUIAnimalCategoryController.class);
	@Autowired
	MantemCategoriaAnimal service;

	/* É necessário adicionar o objeto no modelAndView 
	 * para que possa utilizar os dados dele no frontend, 
	 * exemplo: na view de clientes, fazer um loop de todos os dados armazenados de clientes
	*/

	@GetMapping("/categorias-animais")
	public ModelAndView showAnimalCategory(CategoriaAnimal categoriaAnimal) {
		ModelAndView modelAndView = new ModelAndView("animalCategory/animalCategory");
		modelAndView.addObject("categoriasAnimais", service.searchAll());

		return modelAndView;
	}

	@GetMapping("/criar-categoria-animal")
    public ModelAndView showCreateAnimalCategory(CategoriaAnimal categoriaAnimal) {
		ModelAndView modelAndView = new ModelAndView("animalCategory/CreateAnimalCategory");
		modelAndView.addObject("categoriaAnimal", categoriaAnimal);

		return modelAndView;
    }

    @PostMapping("/criar-categoria-animal")
	public RedirectView createAnimalCategory(@Valid CategoriaAnimal categoriaAnimal, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/criar-categoria-animal?status=Erro&text=Revise_os_campos_do_registro!");
		}

		if (!service.save(categoriaAnimal).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("animalCategory/CreateAnimalCategory");
			modelAndView.addObject("message", "Dados invalidos");
		}

		return new RedirectView("/categorias-animais?status=Cadastrado");
	}

	@GetMapping("/atualizar-categoria-animal/{id}")
    public ModelAndView showUpdateAnimalCategory(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("animalCategory/UpdateAnimalCategory");
		modelAndView.addObject("categoriaAnimal", service.searchById(id).get());

		return modelAndView;
    }

	@PostMapping("/atualizar-categoria-animal/{id}")
	public RedirectView updateAnimalCategory(@PathVariable("id") Long id, @Valid CategoriaAnimal categoriaAnimal, BindingResult result) {
		if (result.hasErrors()) {
			categoriaAnimal.setId(id);
			
			return new RedirectView("/atualizar-categoria-animal/{id}?status=Erro&text=Revise_os_campos_do_registro!");
		}
		service.updates(id, categoriaAnimal);
				
		return new RedirectView("/categorias-animais?status=Atualizado");
	}

	@GetMapping("/deletar-categoria-animal/{id}")
	public RedirectView deleteAnimalCategory(@PathVariable("id") Long id) {
		service.delete(id);
		return new RedirectView("/categorias-animais");
	}
}