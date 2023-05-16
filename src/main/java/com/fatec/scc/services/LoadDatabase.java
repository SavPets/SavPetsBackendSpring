package com.fatec.scc.services;

import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.adoptionCampaign.MaintainAdoptionCampaignRepository;
import com.fatec.scc.model.client.Client;
import com.fatec.scc.model.client.MaintainClientRepository;
import com.fatec.scc.model.employee.Employee;
import com.fatec.scc.model.employee.MaintainEmployeeRepository;
import com.fatec.scc.model.occupation.MaintainOccupationRepository;
import com.fatec.scc.model.occupation.Occupation;
import com.fatec.scc.services.occupation.MaintainOccupation;
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
	CommandLineRunner initDatabase(MaintainAdoptionCampaignRepository maintainAdoptionCampaignRepository, MaintainEmployeeRepository maintainEmployeeRepository, MaintainOccupationRepository maintainOccupationRepository, MaintainClientRepository maintainClientRepository, MaintainProviderRepository maintainProviderRepository) {
		return args -> {
			maintainAdoptionCampaignRepository.deleteAll();
			AdoptionCampaign adoptionCampaign = new AdoptionCampaign("Patas em Busca de Lar", "Em nosso evento, você terá a oportunidade de conhecer cães e gatos resgatados, prontos para encontrar um lar amoroso e oferecer carinho, lealdade e momentos de felicidade.", "2023-05-15", "07:00", "21:00", "Parque Ibirapuera");
			maintainAdoptionCampaignRepository.save(adoptionCampaign);

			maintainEmployeeRepository.deleteAll();
			Employee employee = new Employee("João Paulo", "Texeira", "jpaulo@gmail.com","teteu123","teteu123","94546734010", "03807420", "Rua dos Bobos", 0, "Casa", "123456789", "TI", "Desenvolvedor");
			maintainEmployeeRepository.save(employee);

			maintainOccupationRepository.deleteAll();
			Occupation occupation = new Occupation("Desenvolvedor", "Desenvolvedor de sistemas");
			maintainOccupationRepository.save(occupation);

			maintainClientRepository.deleteAll();
			Client client = new Client("Sued", "Santos", "54906578910", "11987654321", "03807420", "Rua dos Bobos", 0, "Casa");
			maintainClientRepository.save(client);



		};
	}
}