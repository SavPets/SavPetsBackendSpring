package com.fatec.scc.controller.funcionario;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.scc.model.funcionario.Funcionario;
import com.fatec.scc.services.funcionario.MantemFuncionarioI;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class APIFuncionarioController {
	@Autowired
	MantemFuncionarioI mantemFuncionario;
	Funcionario funcionario;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security
	@PostMapping
	public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid Funcionario funcionario, BindingResult result) {
		funcionario = new Funcionario();
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		if (mantemFuncionario.consultaPorCPF(funcionario.getCpf()).isPresent()) {
			logger.info(">>>>>> apicontroller consultaporcpf cpf ja cadastrado");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
		}
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mantemFuncionario.save(funcionario.retornaUmFuncionario()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");
		}
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping
	public ResponseEntity<List<Funcionario>> consultaTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(mantemFuncionario.consultaTodos());
	}

	@CrossOrigin // desabilita o cors do spring security
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePorId(@PathVariable(value = "id") Long id) {
		Optional<Funcionario> funcionario = mantemFuncionario.consultaPorId(id);
		if (funcionario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		mantemFuncionario.delete(funcionario.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body("Funcionário excluido");
	}

	@CrossOrigin // desabilita o cors do spring security
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualiza(@PathVariable long id, @RequestBody @Valid Funcionario funcionario,
			BindingResult result) {
		logger.info(">>>>>> api atualiza informações de funcionario chamado");
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de funcionario chamado dados invalidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		Optional<Funcionario> f = mantemFuncionario.consultaPorId(id);
		if (f.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		Optional<Funcionario> func = mantemFuncionario.atualiza(id, funcionario.retornaUmFuncionario());
		return ResponseEntity.status(HttpStatus.OK).body(func.get());
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping("/{id}")
	public ResponseEntity<Object> consultaPorId(@PathVariable Long id) {
		logger.info(">>>>>> apicontroller consulta por id chamado");
		Optional<Funcionario> funcionario = mantemFuncionario.consultaPorId(id);
		if (funcionario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(funcionario.get());
	}
}