package com.fatec.scc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIHomeController {
	/**
	 * processa a requisicao localhost:8080/
	 * @return a view html
	 */
	
	@GetMapping("/")
	public ModelAndView menu() {
			return new ModelAndView("paginaMenu");
	}
	/**
	 * processa a requisicao localhost:8080/clientes
	 * @return a view html
	 */
	@GetMapping("/clientes")
	public ModelAndView formCliente() {
			return new ModelAndView("cadastrarCliente");
	}
}
