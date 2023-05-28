package com.fatec.scc.services;

import com.fatec.scc.model.adoption.Adoption;
import com.fatec.scc.model.adoption.MaintainAdoptionRepository;
import com.fatec.scc.model.adoptionCampaign.AdoptionCampaign;
import com.fatec.scc.model.adoptionCampaign.MaintainAdoptionCampaignRepository;
import com.fatec.scc.model.animalCategory.AnimalCategory;
import com.fatec.scc.model.animalCategory.MaintainAnimalCategoryRepository;
import com.fatec.scc.model.animalReport.AnimalReport;
import com.fatec.scc.model.animalReport.MaintainAnimalReportRepository;
import com.fatec.scc.model.client.Client;
import com.fatec.scc.model.client.MaintainClientRepository;
import com.fatec.scc.model.departament.Departament;
import com.fatec.scc.model.departament.MaintainDepartamentRepository;
import com.fatec.scc.model.employee.Employee;
import com.fatec.scc.model.employee.MaintainEmployeeRepository;
import com.fatec.scc.model.medicine.MaintainMedicineRepository;
import com.fatec.scc.model.medicine.Medicine;
import com.fatec.scc.model.occupation.MaintainOccupationRepository;
import com.fatec.scc.model.occupation.Occupation;
import com.fatec.scc.model.provider.Provider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.scc.model.provider.MaintainProviderRepository;

@Configuration
class LoadDatabase {
//	@SuppressWarnings("unused")
	final String defaultDate = "2023-05-15";
	
	@Bean
	CommandLineRunner initDatabase(MaintainAdoptionCampaignRepository maintainAdoptionCampaignRepository, MaintainEmployeeRepository maintainEmployeeRepository, MaintainOccupationRepository maintainOccupationRepository,
								   MaintainClientRepository maintainClientRepository, MaintainProviderRepository maintainProviderRepository, MaintainMedicineRepository maintainMedicineRepository, MaintainDepartamentRepository maintainDepartamentRepository,
								   MaintainAnimalCategoryRepository maintainAnimalCategoryRepository, MaintainAnimalReportRepository maintainAnimalReportRepository, MaintainAdoptionRepository maintainAdoptionRepository) {

		return args -> {
			// Campanha de adoção
			//maintainAdoptionCampaignRepository.deleteAll();
			//AdoptionCampaign adoptionCampaign = new AdoptionCampaign("Patas em Busca de Lar", "Em nosso evento, você terá a oportunidade de conhecer cães e gatos resgatados, prontos para encontrar um lar amoroso e oferecer carinho, lealdade e momentos de felicidade.", defaultDate, "07:00", "21:00", "Parque Ibirapuera");
			//maintainAdoptionCampaignRepository.save(adoptionCampaign);
			//adoptionCampaign = new AdoptionCampaign("Gatos em Busca de Lar", "Neste evento, você terá a oportunidade de conhecer gatos resgatados, prontos para encontrar um lar amoroso e oferecer carinho, lealdade e momentos de felicidade.", defaultDate, "10:00", "15:00", "Fatec Zona Leste");
			//maintainAdoptionCampaignRepository.save(adoptionCampaign);

			// Clientes
			maintainClientRepository.deleteAll();
			Client client = new Client("Sued", "Santos", "54906578910", "11987654321", "03807420", "Rua dos Bobos", 0, "Casa");
			maintainClientRepository.save(client);
			maintainClientRepository.deleteAll();
			Client client2 = new Client("Jairo", "Oliveira", "22206575599", "11975429898", "03707510", "Rua do Amanhã", 234, "Apartamento, n12");
			maintainClientRepository.save(client2);

			// Fornecedores
			maintainProviderRepository.deleteAll();
			Provider provider = new Provider("PetShop", "12345678910111", "03807420", "Rua Jacaré", 0, "Casa");
			maintainProviderRepository.save(provider);

			// Medicamentos
			maintainMedicineRepository.deleteAll();
			Medicine medicine = new Medicine("PetShop", "Vacina", "bula exemplo", "Vacina para raiva", defaultDate, "Vacina para raiva", defaultDate, 10, defaultDate);
			maintainMedicineRepository.save(medicine);

			// Categoria de animais
			maintainAnimalCategoryRepository.deleteAll();
			AnimalCategory category = new AnimalCategory("Pitbull-M", "Pitbull", "Macho", "Grande", "Preto");
			maintainAnimalCategoryRepository.save(category);
			AnimalCategory category2 = new AnimalCategory("Vira-lata-M", "Vira-lata", "Macho", "Grande", "Marrom");
			maintainAnimalCategoryRepository.save(category2);
			AnimalCategory category3 = new AnimalCategory("Persa-F", "Persa", "Fêmea", "Pequeno", "Branoa");
			maintainAnimalCategoryRepository.save(category3);
			AnimalCategory category4 = new AnimalCategory("Pastor Alemão-F", "Pastor Alemão", "Fêmea", "Pequeno", "Branco");
			maintainAnimalCategoryRepository.save(category4);
			AnimalCategory category5 = new AnimalCategory("Siamês-M", "Siamês", "Macho", "Pequeno", "Branco");
			maintainAnimalCategoryRepository.save(category5);

			// Relatório de animais
			maintainAnimalReportRepository.deleteAll();
			AnimalReport report = new AnimalReport("Teteu", "Vacina", "Pitbull-M", "2022-08-25", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report);
			AnimalReport report2 = new AnimalReport("Magnos", "Vacina", "Vira-lata-M", "2022-12-18", "Local", "DescriçãoDescrição");
			maintainAnimalReportRepository.save(report2);
			AnimalReport report3 = new AnimalReport("Cacau", "Vacina", "Persa-F", "2022-12-23", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report3);
			AnimalReport report1 = new AnimalReport("Zeus", "Vacina", "Vira-lata-M", "2022-11-04", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report1);
			AnimalReport report5 = new AnimalReport("Chloe", "Vacina", "Persa-F", "2023-02-11", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report5);
			AnimalReport report4 = new AnimalReport("Luna", "Vacina", "Persa-F", "2023-01-23", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report4);
			AnimalReport report6 = new AnimalReport("Simba", "Vacina", "Siamês-M", "2023-03-28", "Local", "Descrição 	Descrição");
			maintainAnimalReportRepository.save(report6);
			AnimalReport report7 = new AnimalReport("Lucy", "Vacina", "Pastor Alemão-F", "2023-04-01", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report7);
			AnimalReport report8 = new AnimalReport("Max", "Vacina", "Vira-lata-M", "2023-04-12", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report8);
			AnimalReport report9 = new AnimalReport("Bella", "Vacina", "Pastor Alemão-F", "2023-04-13", "Local", " DescriçãoDescrição");
			maintainAnimalReportRepository.save(report9);
			AnimalReport report10 = new AnimalReport("Duke", "Vacina", "Pitbull-M", "2023-04-24", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report10);
			AnimalReport report11 = new AnimalReport("Bailey", "Vacina", "Pastor Alemão-F", "2023-05-03", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report11);
			AnimalReport report12 = new AnimalReport("Mel", "Vacina", "Pastor Alemão-F", "2023-05-09", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report12);
			AnimalReport report13 = new AnimalReport("Nina", "Vacina", "Persa-F", "2023-05-23", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report13);
			AnimalReport report14 = new AnimalReport("Vitinho", "Vacina", "Pitbull-M", "2023-05-28", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report14);
			AnimalReport report15 = new AnimalReport("Rex", "Vacina", "Vira-lata-M", "2023-06-03", "Local", "Descrição Descrição");
			maintainAnimalReportRepository.save(report15);

			// Adoção
			maintainAdoptionRepository.deleteAll();
			Adoption adoption = new Adoption("João Paulo", "Sued", 1L, "Teteu", "2023-05-25", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption);
			Adoption adoption2 = new Adoption("Pedro", "Sued", 2L, "Zeus", "2023-10-03", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption2);
			Adoption adoption3 = new Adoption("ADMIN", "Jairo", 3L, "Magnos", "2023-06-04", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption3);
			Adoption adoption4 = new Adoption("ADMIN", "Jairo", 4L, "Cacau", "2023-03-10", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption4);
			Adoption adoption5 = new Adoption("ADMIN", "Jairo", 5L, "Luna", "2023-07-21", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption5);
			Adoption adoption6 = new Adoption("ADMIN", "Jairo", 6L, "Chloe", "2023-08-05", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption6);
			Adoption adoption7 = new Adoption("ADMIN", "Sued", 7L, "Simba", "2023-02-18", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption7);
			Adoption adoption8 = new Adoption("ADMIN", "Sued", 8L, "Lucy", "2023-04-19", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption8);
			Adoption adoption9 = new Adoption("ADMIN", "Jairo", 9L, "Max", "2023-02-18", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption9);
			Adoption adoption10 = new Adoption("ADMIN", "Sued", 10L, "Bella", "2023-03-24", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption10);
			Adoption adoption11 = new Adoption("ADMIN", "Jairo", 11L, "Duke", "2023-12-03", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption11);
			Adoption adoption12 = new Adoption("ADMIN", "Sued", 12L, "Bailey", "2023-01-31", "Descrição  Descrição");
			maintainAdoptionRepository.save(adoption12);

			// Cargo
			maintainOccupationRepository.deleteAll();
			Occupation occupation = new Occupation("Administrador", "Administrador do sistema, acesso total");
			maintainOccupationRepository.save(occupation);
			occupation = new Occupation("Veterinário", "Veterinário associado ao SavPets");
			maintainOccupationRepository.save(occupation);
			occupation = new Occupation("Auxiliar", "Auxiliar geral associado ao SavPets");
			maintainOccupationRepository.save(occupation);
			occupation = new Occupation("Gerente", "Gerente do sistema SavPets");
			maintainOccupationRepository.save(occupation);
			occupation = new Occupation("Almoxarife", "Responsável pelo estoque do sistema SavPets");
			maintainOccupationRepository.save(occupation);

			// Departamento
			maintainDepartamentRepository.deleteAll();
			Departament departament = new Departament("ADM", "ADM");
			maintainDepartamentRepository.save(departament);

			// Funcionário
			maintainEmployeeRepository.deleteAll();
			Employee employee = new Employee("ADMIN", "ADMIN", "admin.admin@email.com", "123123aA!", "123123aA!", "10101010101", "11111111", "Rua", 1, "Casa do adm", "123", "ADM", "Administrador");
			maintainEmployeeRepository.save(employee);
			employee = new Employee("Pedro", "Pessina", "pedro.pessina@gmail.com", "123123aA!", "123123aA!", "111.111.111-11", "03882-100", "Rua Sebastião da Silva Bueno", 1, "", "111", "ADM", "Veterinário");
			maintainEmployeeRepository.save(employee);
			};
	}
}