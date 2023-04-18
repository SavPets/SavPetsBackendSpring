package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;

//	Funciona como CRUD

public interface MantemCategoriaAnimal {
	List<CategoriaAnimal> consultaTodos();

	Optional<CategoriaAnimal> consultaPorNome(String nome);

	Optional<CategoriaAnimal> consultaPorId(Long id);
	
	Optional<CategoriaAnimal> consultaPorRaca(String raca);
	
	Optional<CategoriaAnimal> consultaPorSexo(String sexo);
	
	Optional<CategoriaAnimal> consultaPorPorte(String porte);
	
	Optional<CategoriaAnimal> consultaPorCorPelagem(String corPelagem);

	Optional<CategoriaAnimal> save(CategoriaAnimal categoriaAnimal);

	void delete(Long id);

	Optional<CategoriaAnimal> atualiza(Long id, CategoriaAnimal categoriaAnimal);


}