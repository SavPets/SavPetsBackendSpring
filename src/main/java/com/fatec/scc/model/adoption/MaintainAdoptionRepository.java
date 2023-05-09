package com.fatec.scc.model.adoption;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainAdoptionRepository extends JpaRepository<Adoption,Long> {
	
	Optional <Adoption> findByAdoptionDate(String adoptionDate);
	
	List<Adoption> findByAnimalCategory(String animalCategory);
	
	List<Adoption> findByClient(String client);
	
	List<Adoption> findByEmployee(String employee);
	
	Optional<Adoption> findByReport(String report);
	
	boolean existsByAdoptionDateAndAnimalCategoryAndClientAndEmployeeAndReport(String adoptionDate,String animalCategory,String client,String employee,String report);
}
