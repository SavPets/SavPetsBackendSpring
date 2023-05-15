package com.fatec.scc.services;

import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.adoptionCampaign.MaintainAdoptionCampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.scc.model.client.MaintainClientRepository;
import com.fatec.scc.model.provider.MaintainProviderRepository;

import java.util.Date;

@Configuration
class LoadDatabase {
//	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Bean
	CommandLineRunner initDatabase(MaintainAdoptionCampaignRepository maintainAdoptionCampaignRepository) {
		return args -> {
			maintainAdoptionCampaignRepository.deleteAll();
			AdoptionCampaign adoptionCampaign = new AdoptionCampaign("Patas em Busca de Lar", "Em nosso evento, você terá a oportunidade de conhecer cães e gatos resgatados, prontos para encontrar um lar amoroso e oferecer carinho, lealdade e momentos de felicidade.", "2023-05-15", "07:00", "21:00", "Parque Ibirapuera");
			maintainAdoptionCampaignRepository.save(adoptionCampaign);
		};
	}
}