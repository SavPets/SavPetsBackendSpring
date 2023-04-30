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


import com.fatec.scc.model.categoriaAnimal.CategoriaAnimal;
import com.fatec.scc.model.categoriaAnimal.CategoriaAnimalDTO;
import com.fatec.scc.services.MantemCategoriaAnimalI;

public class APIRelatorioAnimalController {
	@Autowired
	MantemCategoriaAnimalI mantemCategoriaAnimal;
	CategoriaAnimal categoriaAnimal;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security
	@PostMapping
	public ResponseEntity<Object> saveCategoriaAnimal(
			@RequestBody @Valid CategoriaAnimalDTO categoriaAnimalDTO,
			BindingResult result) {
		categoriaAnimal = new CategoriaAnimal();

		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		if (mantemCategoriaAnimal.searchByNome(categoriaAnimalDTO.getNome()).isPresent()) {
			logger.info(">>>>>> apicontroller consultapornome categoria ja cadastrado");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Categoria já cadastrada");
		}
		try {
			categoriaAnimal.setRaca(categoriaAnimalDTO.getRaca());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		try {
			categoriaAnimal.setSexo(categoriaAnimalDTO.getSexo());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		try {
			categoriaAnimal.setPorte(categoriaAnimalDTO.getPorte());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		try {
			categoriaAnimal.setCorPelagem(categoriaAnimalDTO.getCorPelagem());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(mantemCategoriaAnimal.save(categoriaAnimalDTO.retornaUmaCategoriaAnimal()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");
		}
	}

	@CrossOrigin // desabilita o cors do spring security
	@GetMapping
	public ResponseEntity<List<CategoriaAnimal>> FindAll() {
		return ResponseEntity.status(HttpStatus.OK).body(mantemCategoriaAnimal.searchAll());
	}

	@CrossOrigin // desabilita o cors do spring security
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Optional<CategoriaAnimal> categoriaAnimal = mantemCategoriaAnimal.searchById(id);
		if (categoriaAnimal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		mantemCategoriaAnimal.delete(categoriaAnimal.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body("Categoria excluida");
	}

	@CrossOrigin // desabilita o cors do spring security
	@PutMapping("/{id}")
	public ResponseEntity<Object> updates(@PathVariable long id,
			@RequestBody @Valid CategoriaAnimalDTO categoriaAnimalDTO, BindingResult result) {
		logger.info(">>>>>> api atualiza informações da categoria do animal chamada");
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de categoria chamado dados invalidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");
		}
		Optional<CategoriaAnimal> c = mantemCategoriaAnimal.searchById(id);
		if (c.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}

		
		Optional<CategoriaAnimal> categoriaAnimal = mantemCategoriaAnimal.updates(id,
				categoriaAnimalDTO.retornaUmaCategoriaAnimal());
		return ResponseEntity.status(HttpStatus.OK).body(categoriaAnimal.get());
	}

	
	@CrossOrigin // desabilita o cors do spring security
	@GetMapping("/{id}")
	public ResponseEntity<Object> searchById(@PathVariable Long id) {
		logger.info(">>>>>> apicontroller consulta por id chamado");
		Optional<CategoriaAnimal> categoriaAnimal = mantemCategoriaAnimal.searchById(id);
		if (categoriaAnimal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(categoriaAnimal.get());
	}
}