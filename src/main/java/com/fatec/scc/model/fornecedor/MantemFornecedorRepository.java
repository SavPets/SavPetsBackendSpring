package com.fatec.scc.model.fornecedor;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface MantemFornecedorRepository extends JpaRepository<Fornecedor, Long> {
	Optional<Fornecedor> findByCnpj(String cnpj);
	List<Fornecedor> findAllByNomeIgnoreCaseContaining(String nome);
}