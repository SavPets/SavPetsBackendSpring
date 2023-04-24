package com.fatec.scc.model.categoriaAnimal;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta classe abstrai a programação de consultas para acesso ao banco de dados.
 * O nome dos metodos para consulta têm duas partes separadas pela palavra-chave
 * By. A primeira parte é o “find” seguido de By. A segunda parte é o nome do
 * atributo na tabela por exemplo Cpf - findByCpf
 * 
 * @author
 */
@Repository
public interface MantemCategoriaAnimalRepository extends JpaRepository<CategoriaAnimal, Long> {
	Optional<CategoriaAnimal> findByNome(String nome);

	Optional<CategoriaAnimal> findByRaca(String raca);
	
	Optional<CategoriaAnimal> findBySexo(String sexo);
	
	Optional<CategoriaAnimal> findByPorte(String porte);
	
	Optional<CategoriaAnimal> findByCorPelagem(String corPelagem);
	
	List<CategoriaAnimal> findAllByNomeIgnoreCaseContaining(String nome);
}
