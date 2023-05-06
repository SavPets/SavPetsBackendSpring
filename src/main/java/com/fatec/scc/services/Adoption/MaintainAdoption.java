package com.fatec.scc.services.Adoption;

import java.util.List;
import java.util.Optional;

import com.fatec.scc.model.adoption.Adoption;

public interface MaintainAdoption {

	List<Adoption> searchAll();
	
	
	Optional<Adoption> searchById(Long id);
	
	Optional <Adoption> save (Adoption adoption);
	
	
	Optional<Adoption> updates(Long id,Adoption adoption);
	
	void delete(Long id);
	
}
