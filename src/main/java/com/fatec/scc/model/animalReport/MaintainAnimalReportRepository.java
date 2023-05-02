package com.fatec.scc.model.animalReport;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface MaintainAnimalReportRepository extends JpaRepository<AnimalReport, Long> {
	
	
	}
