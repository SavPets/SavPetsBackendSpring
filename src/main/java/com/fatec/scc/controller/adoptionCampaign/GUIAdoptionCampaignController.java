package com.fatec.scc.controller.adoptionCampaign;

import java.util.Optional;

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

import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.adoptionCampaign.AdoptionCampaignDTO;
import com.fatec.scc.model.animalReport.AnimalReport;
import com.fatec.scc.services.adoptionCampaign.MaintainAdoptionCampaign;
import com.fatec.scc.services.animalReport.MaintainAnimalReportI;

@Controller
@RequestMapping
public class GUIAdoptionCampaignController {
	Logger logger = LogManager.getLogger(GUIAdoptionCampaignController.class);
	@Autowired
	MaintainAdoptionCampaign service;
	@Autowired
	MaintainAnimalReportI mantemAnimalReport;

	@GetMapping("/campanhas-adocao")
	public ModelAndView showAdoptionCampaign(AdoptionCampaign campaign) {
		ModelAndView modelAndView = new ModelAndView("adoptionCampaign/adoptionCampaign");
		modelAndView.addObject("campanhasAdocao", service.searchAll());

		return modelAndView;
	}

	@GetMapping("/criar-campanha-adocao")
    public ModelAndView showCreateAdoptionCampaign(AdoptionCampaign campaign) {
		ModelAndView modelAndView = new ModelAndView("adoptionCampaign/createAdoptionCampaign");
		modelAndView.addObject("campanha", campaign);
		modelAndView.addObject("relatoriosAnimais", service.searchAllAnimals());
		
		return modelAndView;
    }

    @PostMapping("/criar-campanha-adocao")
	public RedirectView createAdoptionCampaign(@Valid AdoptionCampaignDTO adoptionCampaignDTO, BindingResult result) {
    	Optional<AnimalReport> animalReport = mantemAnimalReport.searchById(adoptionCampaignDTO.getAnimalId());
		adoptionCampaignDTO.setAnimalName(animalReport.get().getAnimalName());
		adoptionCampaignDTO.setAnimalRace(animalReport.get().getAnimalCategory());
		adoptionCampaignDTO.setArrivalDate(animalReport.get().getArrivalDate());
    	
    	if (result.hasErrors()) {
			return new RedirectView("/criar-campanha-adocaol?status=Erro&text=Revise_os_campos_do_registro!");
		}

		if (!service.save(adoptionCampaignDTO.returnAdoptionCampaign()).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("adoptionCampaign/createAdoptionCampaign");
			modelAndView.addObject("message", "Dados invalidos");
		}
		
		return new RedirectView("/campanhas-adocao?status=Cadastrado");
	}

	@GetMapping("/atualizar-campanha-adocao/{id}")
    public ModelAndView showUpdateAdoptionCampaign(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("adoptionCampaign/updateAdoptionCampaign");
		modelAndView.addObject("campanha", service.searchById(id).get());
		modelAndView.addObject("relatoriosAnimais", service.searchAllAnimals());

		return modelAndView;
    }

	@PostMapping("/atualizar-campanha-adocao/{id}")
	public RedirectView updateAdoptionCampaign(@PathVariable("id") Long id, @Valid AdoptionCampaign adoptionCampaign, BindingResult result) {
		Optional<AnimalReport> animalReport = mantemAnimalReport.searchById(adoptionCampaign.getAnimalId());
		adoptionCampaign.setAnimalName(animalReport.get().getAnimalName());
		adoptionCampaign.setAnimalRace(animalReport.get().getAnimalCategory());
		adoptionCampaign.setArrivalDate(animalReport.get().getArrivalDate());
		
		if (result.hasErrors()) {
			adoptionCampaign.setId(id);
			
			return new RedirectView("/atualizar-campanha-adoacao/{id}?status=Erro&text=Revise_os_campos_do_registro!");
		}
		
		service.updates(id, adoptionCampaign);
				
		return new RedirectView("/campanhas-adocao?status=Atualizado");
	}

	@GetMapping("/deletar-campanha-adocao/{id}")
	public RedirectView deleteAdoptionCampaign(@PathVariable("id") Long id) {
		service.delete(id);
		return new RedirectView("/campanhas-adocao");
}
}
