package com.fatec.scc.model.adoption;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainAdoptionRepository extends JpaRepository<Adoption,Long> {
	
	Optional<Adoption> findByAdoptionDate(String AdoptionDate);
	
	Optional<Adoption> searchById(Long id);
	
	Object searchAll();
	
	Optional<Adoption> updates(long id, Adoption retornoUmaAdocao);
	
	void delete(Long id);
		
}
