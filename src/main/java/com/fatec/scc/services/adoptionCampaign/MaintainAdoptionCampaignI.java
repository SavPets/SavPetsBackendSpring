package com.fatec.scc.services.adoptionCampaign;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.adoptionCampaign.MaintainAdoptionCampaignRepository;
import com.fatec.scc.model.animalReport.AnimalReport;
import com.fatec.scc.model.animalReport.MaintainAnimalReportRepository;

@Service
public class MaintainAdoptionCampaignI implements MaintainAdoptionCampaign {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MaintainAdoptionCampaignRepository repository;
	@Autowired
	MaintainAnimalReportRepository repositoryA;
	
	@Override
	public List<AdoptionCampaign> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}
	
	@Override
	public Optional<AdoptionCampaign> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}
	
	@Override
	public Optional<AdoptionCampaign> save(AdoptionCampaign adoptionCampaign) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(adoptionCampaign));
	}

	@Override
	public Optional<AdoptionCampaign> updates(Long id, AdoptionCampaign adoptionCampaign) {
		logger.info(">>>>>> 1.servico atualiza informações de campanha chamado");
		AdoptionCampaign modifiedCampaign = new AdoptionCampaign(adoptionCampaign.getDate(), adoptionCampaign.getLocation(), adoptionCampaign.getDescription(), adoptionCampaign.getAnimalId(), adoptionCampaign.getAnimalName(), adoptionCampaign.getAnimalRace(), adoptionCampaign.getArrivalDate());

		modifiedCampaign.setId(id);
		
		return Optional.ofNullable(repository.save(modifiedCampaign));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}
	
	@Override
	public List<AnimalReport> searchAllAnimals() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryA.findAll();
	}
}
