package com.fatec.scc.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MantemCadastroRepository extends JpaRepository<Cadastro, Long> {
	Cadastro findByEmail(String email);

	boolean existsByEmail(String email);
}
