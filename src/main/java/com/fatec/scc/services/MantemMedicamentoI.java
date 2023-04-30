package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.fornecedor.MantemFornecedorRepository;
import com.fatec.scc.model.medicamento.MantemMedicamentoRepository;
import com.fatec.scc.model.medicamento.Medicamento;
@Service

public class MantemMedicamentoI implements MantemMedicamento {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemMedicamentoRepository repository;
	@Autowired
	MantemFornecedorRepository repositoryF;
	public List<Medicamento> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}
	public List<Fornecedor> serchAllF() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryF.findAll();
	}
	@Override
	public Optional<Medicamento> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Medicamento> save(Medicamento medicamento) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(medicamento));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Medicamento> updates(Long id, Medicamento medicamento) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		//Endereco endereco = obtemEndereco(fornecedor.getCep());;
		//fornecedorModificado.setEndereco(endereco.getLogradouro());
		
		Medicamento medicamentoModificado = this.repository.findById(id).get();
		medicamento.setId(id);
		
		//if (fornecedor.getCep() == null) {
		//	fornecedor.setCep(fornecedorModificado2.getCep());
		//}
		
		//if (fornecedor.getCnpj() == null) {
			//fornecedor.setCnpj(fornecedorModificado2.getCnpj());
		//}
		
		//if (fornecedor.getComplemento() == null) {
			//fornecedor.setComplemento(fornecedorModificado2.getComplemento());
	//	}
		//if (fornecedor.getEndereco() == null) {
			//fornecedor.setEndereco(fornecedorModificado2.getEndereco());
	//	}
	//	if(fornecedor.getNome() == null) {
	//	fornecedor.setNome(fornecedorModificado2.getNome());
		//}
		
		
		
		logger.info(">>>>>> 2. servico atualiza informacoes de medicamento valido para o id => "
				+ medicamentoModificado.getId());
		return Optional.ofNullable(repository.save(medicamento));
	}
	
}
