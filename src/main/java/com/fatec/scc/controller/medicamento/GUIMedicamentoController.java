package com.fatec.scc.controller.medicamento;

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
import com.fatec.scc.model.medicamento.Medicamento;
import com.fatec.scc.services.fornecedor.MantemFornecedor;
import com.fatec.scc.services.medicamento.MantemMedicamento;
@Controller
@RequestMapping
public class GUIMedicamentoController {
	 Logger logger = LogManager.getLogger(GUIMedicamentoController.class);
		@Autowired
		MantemMedicamento service;
		MantemFornecedor service2;
		/* É necessário adicionar o objeto no modelAndView 
		 * para que possa utilizar os dados dele no frontend, 
		 * exemplo: na view de clientes, fazer um loop de todos os dados armazenados de clientes
		*/

		@GetMapping("/medicamentos")
		public ModelAndView showMedicine(Medicamento medicamento) {
			ModelAndView modelAndView = new ModelAndView("medicine/medicine");
			modelAndView.addObject("medicamentos", service.searchAll());

			return modelAndView;
		}

		@GetMapping("/criar-medicamento")
	    public ModelAndView showCreateMedicine(Medicamento medicamento) {
			ModelAndView modelAndView = new ModelAndView("medicine/CreateMedicine");
			modelAndView.addObject("fornecedores", service.serchAllF());
			modelAndView.addObject("medicamento", medicamento);

			//service.obtemEndereco(fornecedor.getCep());
			
			return modelAndView;
	    }
		@PostMapping("/criar-medicamento")
		public RedirectView createMedicine(@Valid Medicamento medicamento, BindingResult result) {
			if (result.hasErrors()) {
				return new RedirectView("/criar-medicamento");
			}
			if (!service.save(medicamento).isPresent()) {
				ModelAndView modelAndView = new ModelAndView("medicine/CreateMedicine");
				modelAndView.addObject("message", "Dados invalidos");
			}
			return new RedirectView("/medicamentos"); 
		}
		
		
		
		@GetMapping("/atualizar-medicamento/{id}")
	    public ModelAndView showUpdateMedicine(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("medicine/UpdateMedicine");
			modelAndView.addObject("medicamento", service.searchById(id).get());

			return modelAndView;
	    }

		@PostMapping("/atualizar-medicamento/{id}")
		public RedirectView updateMedicine(@PathVariable("id") Long id, @Valid Medicamento medicamento, BindingResult result) {
			if (result.hasErrors()) {
				medicamento.setId(id);
				
				return new RedirectView("/atualizar-medicamento/{id}");
			}
			service.updates(id, medicamento);
					
			return new RedirectView("/medicamentos");
		}
		@GetMapping("/deletar-medicamento/{id}")
		public RedirectView deleteMedicine(@PathVariable("id") Long id) {
			service.delete(id);
			return new RedirectView("/medicamentos");
		}
}	
