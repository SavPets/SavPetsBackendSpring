package com.fatec.scc.controller.client;

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

import com.fatec.scc.model.Endereco;
import com.fatec.scc.model.cliente.Cliente;
import com.fatec.scc.model.cliente.ClienteDTO;
import com.fatec.scc.services.cliente.MantemClienteI;

@RestController
@RequestMapping("/api/v1/clientes")
/*
 * Trata as requisicoes HTTP enviadas pelo usuario do servico
 */
public class APIClientController {
	@Autowired
	MantemClienteI mantemCliente;
	Cliente cliente;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security
	@PostMapping
	public ResponseEntity<Object> saveClient(@RequestBody @Valid ClienteDTO clienteDTO, BindingResult result) {
		cliente = new Cliente();
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		if (mantemCliente.searchByCpf(clienteDTO.getCpf()).isPresent()) {
			logger.info(">>>>>> apicontroller consultaporcpf cpf ja cadastrado");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
		}
		Optional<Endereco> endereco = Optional.ofNullable(mantemCliente.obtemEndereco(clienteDTO.getCep()));
		logger.info(">>>>>> apicontroller obtem endereco => " + clienteDTO.getCep());
		if (endereco.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP invalido");
		}
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mantemCliente.save(clienteDTO.retornaUmCliente()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");
		}
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping
	public ResponseEntity<List<Cliente>> FindAll() {
		return ResponseEntity.status(HttpStatus.OK).body(mantemCliente.searchAll());
	}

	@CrossOrigin // desabilita o cors do spring security
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Optional<Cliente> cliente = mantemCliente.searchById(id);
		if (cliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		mantemCliente.delete(cliente.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido");
	}

	@CrossOrigin // desabilita o cors do spring security
	@PutMapping("/{id}")
	public ResponseEntity<Object> updates(@PathVariable long id, @RequestBody @Valid ClienteDTO clienteDTO,
			BindingResult result) {
		logger.info(">>>>>> api atualiza informações de cliente chamado");
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de cliente chamado dados invalidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		Optional<Cliente> c = mantemCliente.searchById(id);
		if (c.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		Optional<Endereco> e = Optional.ofNullable(mantemCliente.obtemEndereco(clienteDTO.getCep()));
		if (e.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não localizado.");
		}
		Optional<Cliente> cliente = mantemCliente.updates(id, clienteDTO.retornaUmCliente());
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping("/{id}")
	public ResponseEntity<Object> searchById(@PathVariable Long id) {
		logger.info(">>>>>> apicontroller consulta por id chamado");
		Optional<Cliente> cliente = mantemCliente.searchById(id);
		if (cliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}
}