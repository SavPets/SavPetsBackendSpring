package com.fatec.scc.controller.fornecedor;


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
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.services.fornecedor.MantemFornecedor;
@Controller
@RequestMapping
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
			ModelAndView modelAndView = new ModelAndView("provider/provider");
			modelAndView.addObject("fornecedores", service.consultaTodos());

			return modelAndView;
		}

		@GetMapping("/criar-fornecedor")
	    public ModelAndView showCreateProvider(Fornecedor fornecedor) {
			ModelAndView modelAndView = new ModelAndView("provider/CreateProvider");
			modelAndView.addObject("fornecedor", fornecedor);
			
			//service.obtemEndereco(fornecedor.getCep());
			
			return modelAndView;
	    }
		@PostMapping("/criar-fornecedor")
		public RedirectView createFornecedor(@Valid Fornecedor fornecedor, BindingResult result) {
			if (result.hasErrors()) {
				return new RedirectView("/criar-fornecedor?status=Erro&text=Revise_os_campos_do_registro!");
			}
			if (!service.save(fornecedor).isPresent()) {
				ModelAndView modelAndView = new ModelAndView("provider/CreateProvider");
				modelAndView.addObject("message", "Dados invalidos");
			}
			return new RedirectView("/fornecedores?status=Cadastrado"); 
		}
		
		
		
		@GetMapping("/atualizar-fornecedor/{id}")
	    public ModelAndView showUpdateAnimalCategory(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("provider/UpdateProvider");
			modelAndView.addObject("fornecedor", service.consultaPorId(id).get());

			return modelAndView;
	    }

		@PostMapping("/atualizar-fornecedor/{id}")
		public RedirectView atualizaFornecedor(@PathVariable("id") Long id, @Valid Fornecedor fornecedor, BindingResult result) {
			if (result.hasErrors()) {
				fornecedor.setId(id);
				
				return new RedirectView("/atualizar-fornecedor/{id}?status=Erro&text=Revise_os_campos_do_registro!");
			}
			service.atualiza(id, fornecedor);
					
			return new RedirectView("/fornecedores?status=Atualizado");
		}
		@GetMapping("/deletar-fornecedor/{id}")
		public RedirectView deleteFornecedor(@PathVariable("id") Long id) {
			service.delete(id);
			return new RedirectView("/fornecedores");
		}
}
