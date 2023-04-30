package com.fatec.scc.services.relatorioAnimal;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.scc.model.animalReport.RelatorioAnimal;
import com.fatec.scc.model.animalReport.MantemRelatorioAnimalRepository;

@Service
public class MantemRelatorioAnimalI implements MantemRelatorioAnimal {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemRelatorioAnimalRepository repository;

	public List<RelatorioAnimal> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
		
	//public List<RelatorioAnimal> searchAll() {
			//logger.info(">>>>>> servico consultaTodos chamado");
			//return repository.findAll();
	}
	//@Override
	//public Optional<CategoriaAnimal> searchByCategoriaAnimal (String CategoriaAnimal) {
		//logger.info(">>>>>> servico consultaPorNome chamado");
		//return repository.findByCategoriaAnimal(CategoriaAnimal);
	//}
	@Override
	public Optional<RelatorioAnimal> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}
	@Override
	public Optional<RelatorioAnimal> searchByDataChegada (String dataChegada) {
		logger.info(">>>>>> servico consultaPorRaca chamado");
		return repository.findByDataChegada(dataChegada);
	}
	@Override
	public Optional<RelatorioAnimal> searchByLocal(String local) {
		logger.info(">>>>>> servico consultaPorSexo chamado");
		return repository.findByLocal(local);
	}
	@Override
	public Optional<RelatorioAnimal> searchByDescricao(String descricao) {
		logger.info(">>>>>> servico consultaPorPorte chamado");
		return repository.findByDescricao(descricao);
	}
	@Override
	public Optional<RelatorioAnimal> searchByMedicamento(String Medicamento) {
		logger.info(">>>>>> servico consultaPorPorte chamado");
		return repository.findByDescricao(Medicamento);
	}
	@Override
	public Optional<RelatorioAnimal> searchByCategoriaAnimal(String CategoriaAnimal) {
		logger.info(">>>>>> servico consultaPorPorte chamado");
		return repository.findByCategoriaAnimal(CategoriaAnimal);
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

	// Verificar: 
	@Override
	public Optional<RelatorioAnimal> updates (Long id, RelatorioAnimal relatorioAnimal) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		
		RelatorioAnimal relatorioAnimalModificado = new RelatorioAnimal(relatorioAnimal.getdataChegada(), relatorioAnimal.getlocal(), relatorioAnimal.getdescricao(),relatorioAnimal.getMedicamento(),relatorioAnimal.getcategoriaAnimal());
		relatorioAnimalModificado.setId(id);
		
		logger.info(">>>>>> 2. servico atualiza informacoes de cliente cep valido para o id => "
				+ relatorioAnimalModificado.getId());
		return Optional.ofNullable(repository.save(relatorioAnimalModificado));
	}
}
