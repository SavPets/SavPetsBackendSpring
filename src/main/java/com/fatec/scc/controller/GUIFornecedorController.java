package com.fatec.scc.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.services.MantemFornecedor;

public class GUIFornecedorController {
	 Logger logger = LogManager.getLogger(GUIFornecedorController.class);
		@Autowired
		MantemFornecedor service;

		/* É necessário adicionar o objeto no modelAndView 
		 * para que possa utilizar os dados dele no frontend, 
		 * exemplo: na view de clientes, fazer um loop de todos os dados armazenados de clientes
		*/

		@GetMapping("/fornecedores")
		public ModelAndView showFornecedores(Fornecedor fornecedor) {
			ModelAndView modelAndView = new ModelAndView("/provider/provider");
			modelAndView.addObject("fornecedores", service.consultaTodos());

			return modelAndView;
		}

		
}
