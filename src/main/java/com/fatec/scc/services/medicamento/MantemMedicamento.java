package com.fatec.scc.services.medicamento;

import java.util.List;
import java.util.Optional;

import com.fatec.scc.model.cliente.Cliente;
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.medicamento.Medicamento;

public interface MantemMedicamento {

	List<Medicamento> searchAll();
	
	List<Fornecedor> serchAllF();
	
	Optional<Medicamento> searchById(Long id);

	Optional<Medicamento> save(Medicamento medicamento);

	void delete(Long id);

	Optional<Medicamento> updates(Long id, Medicamento medicamento);

	
}
