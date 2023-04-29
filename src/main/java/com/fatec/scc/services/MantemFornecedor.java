package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import com.fatec.scc.model.fornecedor.Fornecedor;

public interface MantemFornecedor {
	List<Fornecedor> consultaTodos();

	Optional<Fornecedor> consultaPorCnpj(String cnpj);

	Optional<Fornecedor> consultaPorId(Long id);

	Optional<Fornecedor> save(Fornecedor fornecedor);

	void delete(Long id);

	Optional<Fornecedor> atualiza(Long id, Fornecedor fornecedor);

	//Endereco obtemEndereco(String cep);

}