package com.fatec.scc.services.cliente;

import java.util.List;
import java.util.Optional;

import com.fatec.scc.model.Endereco;
import com.fatec.scc.model.cliente.Cliente;

public interface MantemCliente {
	List<Cliente> searchAll();

	Optional<Cliente> searchByCpf(String cpf);

	Optional<Cliente> searchById(Long id);

	Optional<Cliente> save(Cliente cliente);

	void delete(Long id);

	Optional<Cliente> updates(Long id, Cliente cliente);

	Endereco obtemEndereco(String cep);
}