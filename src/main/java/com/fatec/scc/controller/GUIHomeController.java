package com.fatec.scc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.scc.model.register.Register;
import com.fatec.scc.services.MaintainRegister;

@Controller
public class GUIHomeController {
	// Rotas de acesso
	String username;
	
	@Autowired
	MaintainRegister service;

	@GetMapping("/home")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@GetMapping("/")
	public ModelAndView showIndex(Register register) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/")
	public RedirectView verifyCadastro(@Valid Register register, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/?status=Erro&text=Revise_os_campos_de_login!");
		}
		
		if (!service.existsByEmail(register.getEmail())) {
			return new RedirectView("/cadastrar?status=Erro&text=Cadastre-se_para_acessar_o_sistema!");
		}
		
		if (service.verify(register.getEmail(), register.getPassword())) {
			username = service.searchByEmail(register.getEmail()).get().getName();
			return new RedirectView("/painel");
		}

		return new RedirectView("/?status=Erro&text=Senha_incorreta!");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView showISignUp(Register register) {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/criar-cadastro")
	public RedirectView createCadastro(@Valid Register register, BindingResult result) {
		if (service.existsByEmail(register.getEmail())) {
			return new RedirectView("/cadastrar?status=Erro&text=Email_em_uso!");
		}
		
		if (!register.getPassword().equals(register.getRepeatPassword())) {
			return new RedirectView("/cadastrar?status=Erro&text=Senhas_diferentes!");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/cadastrar?status=Erro&text=Revise_os_campos!");
		}

		if (!service.save(register).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("signup");
			modelAndView.addObject("message", "Dados inválidos");
		}
		
		username = register.getName();
		
		return new RedirectView("/painel?status=Cadastrado");
	}
	
	@GetMapping("/alterar-senha")
	public ModelAndView showUpdateCadastro(Register register) {
		ModelAndView mv = new ModelAndView("changePassword");
		mv.addObject("cadastro", register);
		return mv;
	}
	
	@PostMapping("/alterar-senha")
	public RedirectView updateCadastro(@Valid Register register, BindingResult result) {
		if (!service.existsByEmail(register.getEmail())) {
			return new RedirectView("/cadastrar?status=Erro&text=Credenciais_sem_cadastro!");
		}
		
		if (!register.getPassword().equals(register.getRepeatPassword())) {
			return new RedirectView("/alterar-senha?status=Erro&text=Senhas_diferentes!");
		}
		
		if (result.hasErrors()) {
			return new RedirectView("/alterar-senha?status=Erro&text=Revise_os_campos!");
		}
		service.updates(register.getEmail(), register.getPassword());

		return new RedirectView("/?status=Atualizado");
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
