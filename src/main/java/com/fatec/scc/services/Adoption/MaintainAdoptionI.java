package com.fatec.scc.services.Adoption;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.scc.model.adoption.Adoption;
import com.fatec.scc.model.adoption.MaintainAdoptionRepository;
import com.fatec.scc.model.animalCategory.AnimalCategory;
import com.fatec.scc.model.animalCategory.MaintainAnimalCategoryRepository;
import com.fatec.scc.model.client.Client;
import com.fatec.scc.model.client.MaintainClientRepository;
import com.fatec.scc.model.employee.Employee;
import com.fatec.scc.model.employee.MaintainEmployeeRepository;

@Service
public class MaintainAdoptionI implements MaintainAdoption {
	
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MaintainEmployeeRepository repositoryE;
	@Autowired
	MaintainClientRepository repositoryC;
	@Autowired
	MaintainAnimalCategoryRepository repositoryA;
	@Autowired
	MaintainAdoptionRepository repository;
	
	
	
	public List<Adoption> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}
	public List<Employee> searchAllEmployee() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryE.findAll();
	}
	public List<Client> searchAllClient() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryC.findAll();
	}
	public List<AnimalCategory> searchAllAnimalCategory() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryA.findAll();
	}
	
	@Override
	public Optional<Adoption> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Adoption> save(Adoption adoption) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(adoption));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Adoption> updates(Long id, Adoption adoption) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		//Endereco endereco = obtemEndereco(fornecedor.getCep());;
		//fornecedorModificado.setEndereco(endereco.getLogradouro());
		
		Adoption relatorioModificado = this.repository.findById(id).get();
		adoption.setId(id);
		
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
		return Optional.ofNullable(repository.save(adoption));
	}

}