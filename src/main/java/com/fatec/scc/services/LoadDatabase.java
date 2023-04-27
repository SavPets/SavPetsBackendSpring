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
		};
	}
}