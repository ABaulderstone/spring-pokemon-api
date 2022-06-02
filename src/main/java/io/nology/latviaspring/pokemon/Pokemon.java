package io.nology.latviaspring.pokemon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name;
	
	@Column
	Integer hp;
	
	@Column
	Integer attack;
	
	@Column
	Integer remainingHp;
	
	public Pokemon() { 
		
	}

	public Pokemon(Long id, String name, Integer hp, Integer attack, Integer remainingHp) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.remainingHp = remainingHp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getRemainingHp() {
		return remainingHp;
	}

	public void setRemainingHp(Integer remainingHp) {
		this.remainingHp = remainingHp;
	}

	public Integer getAttack() {
		return this.attack;
		
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
		
	}
	
	
	

}
