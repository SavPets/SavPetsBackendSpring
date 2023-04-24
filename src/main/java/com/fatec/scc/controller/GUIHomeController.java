package com.fatec.scc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIHomeController {
	// Rotas de acesso
	
	@GetMapping("/")
	public ModelAndView showIndex() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView showISignUp() {
		return new ModelAndView("signup");
	}
	
	@GetMapping("/alterar-senha")
	public ModelAndView showIChangePassword() {
		return new ModelAndView("changePassword");
	}

	@GetMapping("/painel")
	public ModelAndView showPanel() {
		return new ModelAndView("panel");
	}
}
