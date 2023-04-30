package com.fatec.scc.services.categoriaAnimal;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;

//	Funciona como CRUD

public interface MantemCategoriaAnimal {
	List<CategoriaAnimal> searchAll();

	Optional<CategoriaAnimal> searchByNome(String nome);

	Optional<CategoriaAnimal> searchById(Long id);
	
	Optional<CategoriaAnimal> searchByRaca(String raca);
	
	Optional<CategoriaAnimal> searchBySexo(String sexo);
	
	Optional<CategoriaAnimal> searchByPorte(String porte);
	
	Optional<CategoriaAnimal> searchByCorPelagem(String corPelagem);

	Optional<CategoriaAnimal> save(CategoriaAnimal categoriaAnimal);

	void delete(Long id);

	Optional<CategoriaAnimal> updates(Long id, CategoriaAnimal categoriaAnimal);


}