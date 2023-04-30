package com.fatec.scc.services.funcionario;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.scc.model.funcionario.Funcionario;
import com.fatec.scc.model.funcionario.MantemFuncionarioRepository;

@Service
public class MantemFuncionarioI implements MantemFuncionario {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemFuncionarioRepository repository;

	public List<Funcionario> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Funcionario> consultaPorCPF(String cpf) {
		logger.info(">>>>>> servico consultaPorCpf chamado");
		return repository.findByCpf(cpf);
	}

	@Override
	public Optional<Funcionario> consultaPorId(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Funcionario> save(Funcionario funcionario) {
		logger.info(">>>>>> servico save chamado ");
		funcionario.setSenha("123");
		funcionario.setRepetirSenha("123");
		return Optional.ofNullable(repository.save(funcionario));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Funcionario> atualiza(Long id, Funcionario funcionario) {
		logger.info(">>>>>> 1.servico atualiza informações de funcionario chamado");
		Funcionario funcionarioModificado = new Funcionario(funcionario.getNome(), funcionario.getSobrenome(), funcionario.getEmail(), funcionario.getSenha(), funcionario.getRepetirSenha(), funcionario.getCpf(), funcionario.getCep(), funcionario.getEndereco(), funcionario.getComplemento(), funcionario.getNumeroConta());
		Funcionario funcionarioModificado2 = this.repository.findById(id).get();

		funcionarioModificado.setId(id);
		
		
		if (funcionario.getCpf() == null) {
			funcionario.setCpf(funcionarioModificado2.getCpf());
		}
		
		
		funcionarioModificado.setCpf(funcionario.getCpf());
		return Optional.ofNullable(repository.save(funcionarioModificado));
	}
}