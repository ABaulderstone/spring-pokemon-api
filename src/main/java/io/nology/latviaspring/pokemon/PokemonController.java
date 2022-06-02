package io.nology.latviaspring.pokemon;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pokemons")

public class PokemonController {
	
	@Autowired private PokemonService service;
	
	@PostMapping()
	public ResponseEntity<Pokemon> create(@Valid @RequestBody PokemonCreateDTO data) {
		Pokemon record = this.service.create(data);
		
		return new ResponseEntity<>(record, HttpStatus.CREATED); 
	}
	
	@PostMapping(value = "/{id}/attack")
	public ResponseEntity<Pokemon> attack(@PathVariable Long id, @Valid @RequestBody PokemonAttackDTO data) { 
		
		boolean isSuccess = this.service.attack(id, data.getId());
		if(!isSuccess) { 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public List<Pokemon> all() { 
		return this.service.all();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pokemon> find(@PathVariable Long id) { 
		Optional<Pokemon> maybePokemon = this.service.find(id);
		if(maybePokemon.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(maybePokemon.get(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> delete(@PathVariable Long id) {
		boolean isDeleted = this.service.delete(id);
		if (!isDeleted) { 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
