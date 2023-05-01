package com.fatec.scc.model.animalReport;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface MantemRelatorioAnimalRepository extends JpaRepository<RelatorioAnimal, Long> {
	
	Optional<RelatorioAnimal> findByMedicamento(String Medicamento);
	
	Optional<RelatorioAnimal> findByCategoriaAnimal(String CategoriaAnimal);

	
	Optional <RelatorioAnimal> findByDataChegada(String dataChegada);
	
	Optional<RelatorioAnimal> findByLocal(String local);
	
	Optional <RelatorioAnimal> findByDescricao(String descricao);
	
	
	}
