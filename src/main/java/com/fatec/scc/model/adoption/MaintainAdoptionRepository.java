package com.fatec.scc.model.adoption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainAdoptionRepository extends JpaRepository<Adoption,Long> {
	
}
