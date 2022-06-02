package io.nology.latviaspring.pokemon;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PokemonCreateDTO {
	@NotBlank
	String name;
	
	@NotNull
	Integer hp;
	@NotNull
	Integer attack;
	
	public PokemonCreateDTO(@NotBlank String name, @NotNull Integer hp, @NotNull Integer attack) {
		super();
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

}
