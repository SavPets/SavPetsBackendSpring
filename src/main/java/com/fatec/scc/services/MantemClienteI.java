package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.fatec.scc.model.Endereco;
import com.fatec.scc.model.cliente.Cliente;
import com.fatec.scc.model.cliente.MantemClienteRepository;

/**
 * A classe mantem cliente implementa o padrao Service. Servce eh um padrao que
 * basicamente encapsula o processo de obtencao de serviços(objetos). O Service
 * cria uma camada de abstracao neste processo. Ao inves da classe dependente
 * instanciar suas dependencias diretamente, eles são solicitados a partir de um
 * objeto centralizado que atua como localizador de serviços.
 * 
 * @author
 *
 */
@Service
public class MantemClienteI implements MantemCliente {
	// Todo o código que está comentado será implementado futuramente com a API "ViaCEP"
	
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemClienteRepository repository;

	public List<Cliente> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> searchByCpf(String cpf) {
		logger.info(">>>>>> servico consultaPorCpf chamado");
		return repository.findByCpf(cpf);
	}

	@Override
	public Optional<Cliente> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	
	@Override 
	public Optional<Cliente> save(Cliente cliente) { 
	 logger.info(">>>>>> servico save chamado ");
	 String endereco = cliente.getEndereco();
	 cliente.setEndereco(endereco);
	 return Optional.ofNullable(repository.save(cliente)); 
	}


	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Cliente> updates(Long id, Cliente cliente) {
		logger.info(">>>>>> 1.servico atualiza informações de funcionario chamado");
		//Cliente clienteModificado = new Cliente(cliente.getPrimeiroNome(), cliente.getUltimoNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getCep(), cliente.getEndereco(), cliente.getNumeroLocal(), cliente.getComplemento());
		//clienteModificado.setId(id);
		Cliente clienteMod = this.repository.findById(id).get();
		cliente.setId(id);
		
		if (cliente.getPrimeiroNome() == null) {
			cliente.setPrimeiroNome(clienteMod.getPrimeiroNome());
		}
		
		if (cliente.getUltimoNome() == null) {
			cliente.setUltimoNome(clienteMod.getUltimoNome());
		}
		
		if (cliente.getCpf() == null) {
			cliente.setCpf(clienteMod.getCpf());
		}
		if(cliente.getTelefone() == null) {
			cliente.setTelefone(clienteMod.getTelefone());
		}
		if (cliente.getCep() == null) {
			cliente.setCep(clienteMod.getCep());
		}
		if (cliente.getEndereco() == null) {
			cliente.setEndereco(clienteMod.getEndereco());
		}
		if (cliente.getNumeroLocal() == null) {
			cliente.setNumeroLocal(clienteMod.getNumeroLocal());
		}
		if (cliente.getComplemento() == null) {
			cliente.setComplemento(clienteMod.getComplemento());
		}
		
		logger.info(">>>>>> 2. servico atualiza informacoes de cliente cep valido para o id => "
				+ clienteMod.getId());
		return Optional.ofNullable(repository.save(cliente));
	}

	public Endereco obtemEndereco(String cep) {
		RestTemplate template = new RestTemplate();
		String url = "https://viacep.com.br/ws/{cep}/json/";
		logger.info(">>>>>> servico consultaCep - " + cep);
		ResponseEntity<Endereco> resposta = null;
		try {
			resposta = template.getForEntity(url, Endereco.class, cep);
			return resposta.getBody();
		} catch (ResourceAccessException e) {
			logger.info(">>>>>> consulta CEP erro não esperado ");
			return null;
		} catch (HttpClientErrorException e) {
			logger.info(">>>>>> consulta CEP inválido erro HttpClientErrorException =>" + e.getMessage());
			return null;
		}
	}
}