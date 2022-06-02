package io.nology.latviaspring.pokemon;

import javax.validation.constraints.NotNull;

public class PokemonAttackDTO {
	@NotNull 
	Long id;

	public PokemonAttackDTO(@NotNull Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
