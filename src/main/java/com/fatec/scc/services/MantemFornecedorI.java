package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.fornecedor.MantemFornecedorRepository;
import com.fatec.scc.model.Endereco;

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
public class MantemFornecedorI implements MantemFornecedor {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemFornecedorRepository repository;

	public List<Fornecedor> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Fornecedor> consultaPorCnpj(String cnpj) {
		logger.info(">>>>>> servico consultaPorCpf chamado");
		return repository.findByCnpj(cnpj);
	}

	@Override
	public Optional<Fornecedor> consultaPorId(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Fornecedor> save(Fornecedor fornecedor) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(fornecedor));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Fornecedor> atualiza(Long id, Fornecedor fornecedor) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		//Endereco endereco = obtemEndereco(fornecedor.getCep());
		Fornecedor fornecedorModificado = new Fornecedor(fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getCep(), fornecedor.getComplemento());
		fornecedorModificado.setId(id);
		//fornecedorModificado.setEndereco(endereco.getLogradouro());
		logger.info(">>>>>> 2. servico atualiza informacoes de cliente cep valido para o id => "
				+ fornecedorModificado.getId());
		return Optional.ofNullable(repository.save(fornecedorModificado));
	}
	//public Endereco obtemEndereco(String cep) {
		//RestTemplate template = new RestTemplate();
		//String url = "https://viacep.com.br/ws/{cep}/json/";
		//logger.info(">>>>>> servico consultaCep - " + cep);
		//ResponseEntity<Endereco> resposta = null;
		//try {
			//resposta = template.getForEntity(url, Endereco.class, cep);
			//return resposta.getBody();
		//} catch (ResourceAccessException e) {
			//logger.info(">>>>>> consulta CEP erro nao esperado ");
		//} catch (HttpClientErrorException e) {
			//logger.info(">>>>>> consulta CEP inválido erro HttpClientErrorException =>" + e.getMessage());
			//return null;
		//}
	//}
}