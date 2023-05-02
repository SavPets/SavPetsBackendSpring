package com.fatec.scc.controller;

import javax.validation.Valid;

import com.fatec.scc.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.scc.services.MaintainRegister;

@Controller
public class GUIHomeController {
	// Rotas de acesso
	
	String username;
	
	@Autowired
	MaintainRegister service;
	
	@GetMapping("/")
	public ModelAndView showIndex(Register register) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/")
	public RedirectView verifyCadastro(@Valid Register register, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/");
		}
		if (!service.existsByEmail(register.getEmail())) {
			return new RedirectView("/cadastrar");
		}
		if (service.verify(register.getEmail(), register.getPassword())) {
			return new RedirectView("/painel");
			//return new RedirectView("/painel/"+String.valueOf(cadastro.getId()));
		}
		
		username = register.getName();
		
		return new RedirectView("/");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView showISignUp(Register register) {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/criar-cadastro")
	public RedirectView createCadastro(@Valid Register register, BindingResult result) {
		if (!register.getPassword().equals(register.getRepeatPassword())) {
			return new RedirectView("/cadastrar");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/cadastrar");
		}

		if (!service.save(register).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("signup");
			modelAndView.addObject("message", "Dados inválidos");
		}
		
		username = register.getName();
		
		return new RedirectView("/painel");
	}
	
	@GetMapping("/alterar-senha")
	public ModelAndView showUpdateCadastro(Register register) {
		ModelAndView mv = new ModelAndView("changePassword");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/alterar-senha")
	public RedirectView updateCadastro(@Valid Register register, BindingResult result) {
		if (!register.getPassword().equals(register.getRepeatPassword())) {
			return new RedirectView("/alterar-senha");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/alterar-senha");
		}
		service.updates(register.getEmail(), register.getPassword());

		return new RedirectView("/");
	}

	@GetMapping("/painel")
	public ModelAndView showPanel(@Valid Register register, BindingResult result) {
		ModelAndView mv = new ModelAndView("panel");
		mv.addObject("username", username);
		return mv;
	}
	
	@GetMapping("/error")
	public ModelAndView showError() {
		return new ModelAndView("error");
	}
}
