package com.fatec.scc.services.relatorioAnimal;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.scc.model.animalReport.RelatorioAnimal;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;
import com.fatec.scc.model.categoriaAnimal.MantemCategoriaAnimalRepository;
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.fornecedor.MantemFornecedorRepository;
import com.fatec.scc.model.medicamento.MantemMedicamentoRepository;
import com.fatec.scc.model.medicamento.Medicamento;
import com.fatec.scc.model.animalReport.MantemRelatorioAnimalRepository;

@Service
public class MantemRelatorioAnimalI implements MantemRelatorioAnimal {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemMedicamentoRepository repositoryM;
	@Autowired
	MantemCategoriaAnimalRepository repositoryC;
	@Autowired
	MantemRelatorioAnimalRepository repository;
	
	
	
	public List<RelatorioAnimal> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}
	public List<Medicamento> serchAllMedicamentos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryM.findAll();
	}
	public List<CategoriaAnimal> serchAllCategorias() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryC.findAll();
	}
	@Override
	public Optional<RelatorioAnimal> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<RelatorioAnimal> save(RelatorioAnimal relatorioAnimal) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(relatorioAnimal));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<RelatorioAnimal> updates(Long id, RelatorioAnimal relatorioAnimal) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		//Endereco endereco = obtemEndereco(fornecedor.getCep());;
		//fornecedorModificado.setEndereco(endereco.getLogradouro());
		
		RelatorioAnimal relatorioModificado = this.repository.findById(id).get();
		relatorioAnimal.setId(id);
		
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
				+ relatorioModificado.getId());
		return Optional.ofNullable(repository.save(relatorioAnimal));
	}

}
