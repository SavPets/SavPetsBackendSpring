package com.fatec.scc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.scc.model.cliente.Cliente;
import com.fatec.scc.model.cliente.MantemClienteRepository;
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.fornecedor.MantemFornecedorRepository;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Autowired
	MantemClienteRepository clienteRepository;
	MantemFornecedorRepository mantemRepository;

	@Bean
	CommandLineRunner initDatabase(MantemClienteRepository repository, MantemFornecedorRepository fornecedorRepository) {
		return args -> {
			repository.deleteAll();
			Cliente cliente1 = new Cliente("Jose da Silva", "01/03/1964", "M", "59672555598", "03694000", "2983");
			cliente1.setEndereco("Aguia de Haia");
			log.info("Preloading " + repository.save(cliente1));
			Cliente cliente2 = new Cliente("Carlos Alberto", "19/08/1970", "M", "16467548671", "04280130", "59");
			cliente2.setEndereco("Rua Frei Joao");
			log.info("Preloading " + repository.save(cliente2));
			
			fornecedorRepository.deleteAll();
			Fornecedor fornecedor1 = new Fornecedor("Nome", "1111111-0001", "04280130", "2983");
			fornecedor1.setEndereco("Aguia de Haia");
			log.info("Preloading " + fornecedorRepository.save(fornecedor1));
			Fornecedor fornecedor2 = new Fornecedor("Nome", "2222222-0001", "03694000", "59");
			fornecedor2.setEndereco("Aguia de Haia");
			log.info("Preloading " + fornecedorRepository.save(fornecedor2));
			
		};
	}
}