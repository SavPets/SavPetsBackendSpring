package com.fatec.scc.model.medicamento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.model.funcionario.Funcionario;

public interface MantemMedicamentoRepository extends JpaRepository<Medicamento, Long>{
}
