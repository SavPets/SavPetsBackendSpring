package com.fatec.scc.model.animalReport;
import org.springframework.stereotype.Repository;

import com.fatec.scc.model.fornecedor.Fornecedor;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface MantemRelatorioAnimalRepository extends JpaRepository<RelatorioAnimal, Long> {
	
	
	}
