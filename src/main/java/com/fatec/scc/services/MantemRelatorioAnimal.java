package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.animalReport.RelatorioAnimal;

public interface MantemRelatorioAnimal {
	List<RelatorioAnimal> searchAll();

	Optional<RelatorioAnimal> searchByNome(String nome);

	Optional<RelatorioAnimal> searchById(Long id);
	
	Optional<RelatorioAnimal> searchByRaca(String raca);
	
	Optional<RelatorioAnimal> searchBySexo(String sexo);
	
	Optional<RelatorioAnimal> searchByPorte(String porte);
	
	Optional<RelatorioAnimal> searchByCorPelagem(String corPelagem);

	Optional<RelatorioAnimal> save(RelatorioAnimal relatorioAnimal);

	void delete(Long id);

	Optional<RelatorioAnimal> updates(Long id, RelatorioAnimal relatorioAnimal);
}
