package com.fatec.scc.services.fornecedor;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.fornecedor.MantemFornecedorRepository;

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
		//Endereco endereco = obtemEndereco(fornecedor.getCep());;
		//fornecedorModificado.setEndereco(endereco.getLogradouro());
		
		Fornecedor fornecedorModificado2 = this.repository.findById(id).get();
		fornecedor.setId(id);
		
		if (fornecedor.getCep() == null) {
			fornecedor.setCep(fornecedorModificado2.getCep());
		}
		
		if (fornecedor.getCnpj() == null) {
			fornecedor.setCnpj(fornecedorModificado2.getCnpj());
		}
		
		if (fornecedor.getComplemento() == null) {
			fornecedor.setComplemento(fornecedorModificado2.getComplemento());
		}
		if (fornecedor.getEndereco() == null) {
			fornecedor.setEndereco(fornecedorModificado2.getEndereco());
		}
		if(fornecedor.getNome() == null) {
			fornecedor.setNome(fornecedorModificado2.getNome());
		}
		
		
		
		logger.info(">>>>>> 2. servico atualiza informacoes de cliente cep valido para o id => "
				+ fornecedorModificado2.getId());
		return Optional.ofNullable(repository.save(fornecedor));
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