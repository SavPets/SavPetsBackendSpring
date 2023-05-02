package com.fatec.scc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.scc.model.client.MaintainClientRepository;
import com.fatec.scc.model.provider.MaintainProviderRepository;

@Configuration
class LoadDatabase {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Autowired
    MaintainClientRepository clienteRepository;
	MaintainProviderRepository mantemRepository;

	@Bean
	CommandLineRunner initDatabase(MaintainClientRepository repository, MaintainProviderRepository fornecedorRepository) {
		return args -> {
		};
	}
}