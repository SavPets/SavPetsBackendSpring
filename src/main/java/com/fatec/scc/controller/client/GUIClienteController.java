package com.fatec.scc.controller.client;

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

import com.fatec.scc.model.cliente.Cliente;
import com.fatec.scc.services.cliente.MantemCliente;

import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
public class GUIClienteController {
	Logger logger = LogManager.getLogger(GUIClienteController.class);
	@Autowired
	MantemCliente service;

	@GetMapping("/clientes")
	public ModelAndView showAllClients() {
		logger.info(">>>>>> controller consulta todos chamado");
		ModelAndView modelAndView = new ModelAndView("client/client");
		modelAndView.addObject("clientes", service.searchAll());
		return modelAndView;
	}

	// Requisição GET que irá mostrar a página de criação de cliente
	@GetMapping("/criar-cliente")
	public ModelAndView showCreateClient(Cliente cliente) {
		ModelAndView mv = new ModelAndView("client/CreateClient");
		mv.addObject("cliente", cliente);
		return mv;
	}

	// Requisição POST que irá criar um novo Cliente
	@PostMapping("/criar-cliente")
	public RedirectView createClient(@Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			return new RedirectView("/criar-cliente");
		}

		if (!service.save(cliente).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("client/CreateClient");
			modelAndView.addObject("message", "Dados inválidos");
		}

		return new RedirectView("/clientes");
	}

	// Requisição GET que irá renderizar a página de Atualização de Cliente
	@GetMapping("/atualizar-cliente/{id}")
	public ModelAndView showUpdateClient(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("client/UpdateClient");
		modelAndView.addObject("cliente", service.searchById(id).get());

		return modelAndView;
	}

	// Requisição POST que irá atualizar um cliente
	@PostMapping("/atualizar-cliente/{id}")
	public RedirectView updateClient(@PathVariable("id") Long id, @Valid Cliente ciente, BindingResult result) {
		if (result.hasErrors()) {
			ciente.setId(id);

			return new RedirectView("/atualizar-cliente/{id}");
		}
		service.updates(id, ciente);

		return new RedirectView("/clientes");
	}

	// Requisição GET que irá renderizar a página para deletar um cliente
	@GetMapping("/deletar-cliente/{id}")
	public RedirectView deleteClient(@PathVariable("id") Long id) {
		service.delete(id);
		return new RedirectView("/clientes");
	}
}