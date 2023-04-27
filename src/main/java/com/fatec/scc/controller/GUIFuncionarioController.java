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
import com.fatec.scc.model.funcionario.Funcionario;
import com.fatec.scc.services.MantemFuncionario;

@Controller
@RequestMapping
public class GUIFuncionarioController {
	 Logger logger = LogManager.getLogger(GUIFuncionarioController.class);
		@Autowired
		MantemFuncionario service;

		@GetMapping("/funcionarios")
		public ModelAndView showFuncionarios(Funcionario funcionario) {
			ModelAndView modelAndView = new ModelAndView("employee/employee");
			modelAndView.addObject("funcionarios", service.consultaTodos());

			return modelAndView;
		}

		@GetMapping("/criar-funcionario")
	    public ModelAndView showCreateFuncionario(Funcionario funcionario) {
			ModelAndView modelAndView = new ModelAndView("employee/CreateEmployee");
			modelAndView.addObject("funcionario", funcionario);
			
			return modelAndView;
	    }
		
		@PostMapping("/criar-funcionario")
		public RedirectView createFuncionario(@Valid Funcionario funcionario, BindingResult result) {
			if (result.hasErrors()) {
				return new RedirectView("/criar-funcionario");
			}
			if (!service.save(funcionario).isPresent()) {
				ModelAndView modelAndView = new ModelAndView("employee/CreateEmployee");
				modelAndView.addObject("message", "Dados invalidos");
			}
			return new RedirectView("/funcionarios"); 
		}
		
		@GetMapping("/atualizar-funcionario/{id}")
	    public ModelAndView showUpdateFuncionario(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("employee/UpdateEmployee");
			modelAndView.addObject("funcionario", service.consultaPorId(id).get());

			return modelAndView;
	    }

		@PostMapping("/atualizar-funcionario/{id}")
		public RedirectView atualizaFuncionario(@PathVariable("id") Long id, @Valid Funcionario funcionario, BindingResult result) {
			if (result.hasErrors()) {
				funcionario.setId(id);
				
				return new RedirectView("/atualizar-funcionarior/{id}");
			}
			service.atualiza(id, funcionario);
					
			return new RedirectView("/funcionarios");
		}
		@GetMapping("/deletar-funcionario/{id}")
		public RedirectView deleteFuncionario(@PathVariable("id") Long id) {
			service.delete(id);
			return new RedirectView("/funcionarios");
		}
}
