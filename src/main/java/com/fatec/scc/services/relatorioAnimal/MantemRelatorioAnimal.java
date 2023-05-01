package com.fatec.scc.services.relatorioAnimal;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.animalReport.RelatorioAnimal;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;
import com.fatec.scc.model.medicamento.Medicamento;

public interface MantemRelatorioAnimal {

	List<RelatorioAnimal> searchAll();
	
	List<Medicamento> serchAllMedicamentos();
	List<CategoriaAnimal> serchAllCategorias();
	
	
	Optional<RelatorioAnimal> searchById(Long id);

	Optional<RelatorioAnimal> save(RelatorioAnimal relatorioAnimal);

	void delete(Long id);

	Optional<RelatorioAnimal> updates(Long id, RelatorioAnimal relatorioAnimal);

	
	
	
}
