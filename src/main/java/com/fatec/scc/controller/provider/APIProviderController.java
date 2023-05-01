package com.fatec.scc.controller.provider;

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
import com.fatec.scc.model.fornecedor.Fornecedor;
import com.fatec.scc.services.fornecedor.MantemFornecedorI;

@RestController
@RequestMapping("/api/v1/fornecedores")
/*
 * Trata as requisicoes HTTP enviadas pelo usuario do servico
 */
public class APIProviderController {
	@Autowired
	MantemFornecedorI mantemFornecedor;
	Fornecedor fornecedor;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security
	@PostMapping
	public ResponseEntity<Object> saveSupplier(@RequestBody @Valid Fornecedor fornecedor, BindingResult result) {
		fornecedor = new Fornecedor();
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		if (mantemFornecedor.consultaPorCnpj(fornecedor.getCnpj()).isPresent()) {
			logger.info(">>>>>> apicontroller consultaporcpf cpf ja cadastrado");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
		}
		
		//Optional<Endereco> endereco = Optional.ofNullable(mantemFornecedor.obtemEndereco(fornecedor.getCep()));
		//logger.info(">>>>>> apicontroller obtem endereco => " + fornecedor.getCep());
		//if (endereco.isEmpty()) {
		//	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP invalido");
		//}
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mantemFornecedor.save(fornecedor.retornaUmFornecedor()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");
		}
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping
	public ResponseEntity<List<Fornecedor>> FindAll() {
		return ResponseEntity.status(HttpStatus.OK).body(mantemFornecedor.consultaTodos());
	}

	@CrossOrigin // desabilita o cors do spring security
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Optional<Fornecedor> fornecedor = mantemFornecedor.consultaPorId(id);
		if (fornecedor.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		mantemFornecedor.delete(fornecedor.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body("Fornecedor excluido");
	}

	@CrossOrigin // desabilita o cors do spring security
	@PutMapping("/{id}")
	public ResponseEntity<Object> updates(@PathVariable long id, @RequestBody @Valid Fornecedor fornecedor,
			BindingResult result) {
		logger.info(">>>>>> api atualiza informações de cliente chamado");
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de cliente chamado dados invalidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		Optional<Fornecedor> c = mantemFornecedor.consultaPorId(id);
		if (c.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		//Optional<Endereco> e = Optional.ofNullable(mantemFornecedor.obtemEndereco(fornecedor.getCep()));
		//if (e.isEmpty()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não localizado.");
		//}
		Optional<Fornecedor> cliente = mantemFornecedor.atualiza(id, fornecedor.retornaUmFornecedor());
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping("/{id}")
	public ResponseEntity<Object> searchById(@PathVariable Long id) {
		logger.info(">>>>>> apicontroller consulta por id chamado");
		Optional<Fornecedor> fornecedor = mantemFornecedor.consultaPorId(id);
		if (fornecedor.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(fornecedor.get());
	}
}