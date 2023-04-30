package com.fatec.scc.services.relatorioAnimal;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.animalReport.RelatorioAnimal;

public interface MantemRelatorioAnimal {
	List<RelatorioAnimal> searchAll();
	
	Optional<RelatorioAnimal> searchByMedicamento(String Medicamento);
	
	Optional<RelatorioAnimal> searchByCategoriaAnimal(String CategoriaAnimal);

	Optional<RelatorioAnimal> searchByDataChegada(String dataChegada);

	Optional<RelatorioAnimal> searchByLocal(String local);

	Optional <RelatorioAnimal> searchByDescricao(String descricao);

	Optional<RelatorioAnimal> searchById(Long id);
	
	Optional<RelatorioAnimal> save(RelatorioAnimal relatorioAnimal);

	void delete(Long id);

	Optional<RelatorioAnimal> updates(Long id, RelatorioAnimal relatorioAnimal);

}
