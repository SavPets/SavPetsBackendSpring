package com.fatec.scc.model.funcionario;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MantemFuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Optional<Funcionario> findByCpf(String cpf);

}