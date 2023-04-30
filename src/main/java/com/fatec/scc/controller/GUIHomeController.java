package com.fatec.scc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.scc.model.Cadastro;
import com.fatec.scc.services.MantemCadastro;

@Controller
public class GUIHomeController {
	// Rotas de acesso
	
	@Autowired
	MantemCadastro service;
	
	@GetMapping("/")
	public ModelAndView showIndex(Cadastro cadastro) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
	@PostMapping("/")
	public RedirectView verifyCadastro(@Valid Cadastro cadastro, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/");
		}
		if (!service.existsByEmail(cadastro.getEmail())) {
			return new RedirectView("/cadastrar");
		}
		if (service.verify(cadastro.getEmail(), cadastro.getSenha())) {
			return new RedirectView("/painel");
			//return new RedirectView("/painel/"+String.valueOf(cadastro.getId()));
		}
		return new RedirectView("/");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView showISignUp(Cadastro cadastro) {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
	@PostMapping("/criar-cadastro")
	public RedirectView createCadastro(@Valid Cadastro cadastro, BindingResult result) {
		if (!cadastro.getSenha().equals(cadastro.getRepetirSenha())) {
			return new RedirectView("/cadastrar");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/cadastrar");
		}

		if (!service.save(cadastro).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("signup");
			modelAndView.addObject("message", "Dados inválidos");
		}

		return new RedirectView("/painel");
	}
	
	@GetMapping("/alterar-senha")
	public ModelAndView showUpdateCadastro(Cadastro cadastro) {
		ModelAndView mv = new ModelAndView("changePassword");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
	@PostMapping("/alterar-senha")
	public RedirectView updateCadastro(@Valid Cadastro cadastro, BindingResult result) {
		if (!cadastro.getSenha().equals(cadastro.getRepetirSenha())) {
			return new RedirectView("/alterar-senha");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/alterar-senha");
		}
		service.updates(cadastro.getEmail(), cadastro.getSenha());

		return new RedirectView("/");
	}

	@GetMapping("/painel")
	public ModelAndView showPanel(@Valid Optional<Cadastro> cadastro, BindingResult result) {
		ModelAndView mv = new ModelAndView("panel");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
	@GetMapping("/error")
	public ModelAndView showError() {
		return new ModelAndView("error");
	}
}
