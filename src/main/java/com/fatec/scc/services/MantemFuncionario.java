package com.fatec.scc.services;

import java.util.Optional;

import com.fatec.scc.model.funcionario.Funcionario;

public interface MantemFuncionario {

	Optional<Funcionario> consultaPorCPF(String cpf);

	Optional<Funcionario> consultaPorId(Long id);

	Optional<Funcionario> save(Funcionario funcionario);

	void delete(Long id);

	Optional<Funcionario> atualiza(Long id, Funcionario funcionario);

	Object consultaTodos();

}
