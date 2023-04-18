package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;
import com.fatec.scc.model.categoriaAnimal.MantemCategoriaAnimalRepository;

/**
 * A classe mantem categoriaAnimal implementa o padrao Service. Service é um padrao que
 * basicamente encapsula o processo de obtencao de serviços(objetos). O Service
 * cria uma camada de abstracao neste processo. Ao inves da classe dependente
 * instanciar suas dependencias diretamente, eles são solicitados a partir de um
 * objeto centralizado que atua como localizador de serviços.
 * 
 * Implementação concreta da interface MantemCategoriaAnimal
 * 
 * @author
 *
 */
@Service
public class MantemCategoriaAnimalI implements MantemCategoriaAnimal {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemCategoriaAnimalRepository repository;

	public List<CategoriaAnimal> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<CategoriaAnimal> consultaPorNome (String nome) {
		logger.info(">>>>>> servico consultaPorNome chamado");
		return repository.findByNome(nome);
	}

	@Override
	public Optional<CategoriaAnimal> consultaPorId(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}
	@Override
	public Optional<CategoriaAnimal> consultaPorRaca(String raca) {
		logger.info(">>>>>> servico consultaPorRaca chamado");
		return repository.findByRaca(raca);
	}
	@Override
	public Optional<CategoriaAnimal> consultaPorSexo(String sexo) {
		logger.info(">>>>>> servico consultaPorSexo chamado");
		return repository.findBySexo(sexo);
	}
	@Override
	public Optional<CategoriaAnimal> consultaPorPorte(String porte) {
		logger.info(">>>>>> servico consultaPorPorte chamado");
		return repository.findByPorte(porte);
	}
	@Override
	public Optional<CategoriaAnimal> consultaPorCorPelagem(String corPelagem) {
		logger.info(">>>>>> servico consultaPorCorPelagem chamado");
		return repository.findByCorPelagem(corPelagem);
	}

	@Override
	public Optional<CategoriaAnimal> save(CategoriaAnimal categoriaAnimal) {
		logger.info(">>>>>> servico save chamado ");
		return Optional.ofNullable(repository.save(categoriaAnimal));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	// Verificar: 
	@Override
	public Optional<CategoriaAnimal> atualiza(Long id, CategoriaAnimal categoriaAnimal) {
		logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
		
		CategoriaAnimal categoriaAnimalModificado = new CategoriaAnimal(categoriaAnimal.getNome(), categoriaAnimal.getRaca(), categoriaAnimal.getSexo(),
				categoriaAnimal.getPorte(), categoriaAnimal.getCorPelagem());
		categoriaAnimalModificado.setId(id);
		
		logger.info(">>>>>> 2. servico atualiza informacoes de cliente cep valido para o id => "
				+ categoriaAnimalModificado.getId());
		return Optional.ofNullable(repository.save(categoriaAnimalModificado));
	}


	
}