package com.fatec.scc.controller.animalReport;
 

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

import com.fatec.scc.model.animalReport.*;
import com.fatec.scc.model.animalReport.RelatorioAnimalDTO;
import com.fatec.scc.services.relatorioAnimal.*;

@RestController
@RequestMapping("/api/v1/relatorio-animais")
/*
 * Trata as requisicoes HTTP enviadas pelo usuario do servico
 */

public class APIRelatorioAnimalController {
	@Autowired
	MantemRelatorioAnimalI mantemRelatorioAnimal;
	RelatorioAnimal relatorioAnimal;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security
	@PostMapping
	public ResponseEntity<Object> saveRelatorioAnimal(
			@RequestBody @Valid RelatorioAnimalDTO relatorioAnimalDTO,
			BindingResult result) {
		relatorioAnimal = new RelatorioAnimal();

		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		
		try {
			relatorioAnimal.setMedicamento(relatorioAnimalDTO.getMedicamento());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(mantemRelatorioAnimal.save(relatorioAnimalDTO.retornoumRelatorioAnimal()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");
		}
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping
	public ResponseEntity<List<RelatorioAnimal>> FindAll() {
		return ResponseEntity.status(HttpStatus.OK).body(mantemRelatorioAnimal.searchAll());
	}

	@CrossOrigin // desabilita o cors do spring security
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Optional<RelatorioAnimal> relatorioAnimal = mantemRelatorioAnimal.searchById(id);
		if (relatorioAnimal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		mantemRelatorioAnimal.delete(relatorioAnimal.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body("Categoria excluida");
	}

	@CrossOrigin // desabilita o cors do spring security
	@PutMapping("/{id}")
	public ResponseEntity<Object> updates(@PathVariable long id,
			@RequestBody @Valid RelatorioAnimalDTO relatorioAnimalDTO, BindingResult result) {
		logger.info(">>>>>> api atualiza informações do relatorio do animal chamada");
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de realtorio chamado dados invalidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		Optional<RelatorioAnimal> r = mantemRelatorioAnimal.searchById(id);
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}

		
		Optional<RelatorioAnimal> relatorioAnimal = mantemRelatorioAnimal.updates(id,
				relatorioAnimalDTO.retornoumRelatorioAnimal());
		return ResponseEntity.status(HttpStatus.OK).body(relatorioAnimal.get());
	}

	
	@CrossOrigin // desabilita o cors do spring security
	@GetMapping("/{id}")
	public ResponseEntity<Object> searchById(@PathVariable Long id) {
		logger.info(">>>>>> apicontroller consulta por id chamado");
		Optional<RelatorioAnimal> relatorioAnimal = mantemRelatorioAnimal.searchById(id);
		if (relatorioAnimal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(relatorioAnimal.get());
	}
}
