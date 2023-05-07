package com.fatec.scc.services.adoptionCampaign;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.animalReport.AnimalReport;

public interface MaintainAdoptionCampaign {

	Object searchAll();

	Optional<AdoptionCampaign> searchById(Long id);
	
	Optional<AdoptionCampaign> save(@Valid AdoptionCampaign adoptionCampaign);

	Optional<AdoptionCampaign> updates(Long id, AdoptionCampaign adoptionCampaign);

	void delete(Long id);

	List<AnimalReport> searchAllAnimals();

}
