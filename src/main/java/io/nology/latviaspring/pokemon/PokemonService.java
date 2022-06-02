package io.nology.latviaspring.pokemon;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PokemonService {
	@Autowired
	private PokemonRepository repository;
	public Pokemon create(PokemonCreateDTO data) { 
		// turn DTO into entity 
		Pokemon newEntity = new Pokemon();
		
		newEntity.setName(data.getName().trim());
		newEntity.setHp(data.getHp());
		newEntity.setAttack(data.getAttack());
		newEntity.setRemainingHp(newEntity.getHp());
		
		//SAVE ENTITY
		this.repository.save(newEntity);
		
		return newEntity;
	}
	
	public boolean attack(Long toAttackId, Long isAttackingId) { 
		Optional<Pokemon> maybeToAttack = this.find(toAttackId);
		Optional<Pokemon> maybeIsAttacking = this.find(isAttackingId);
		if(maybeToAttack.isEmpty() || maybeIsAttacking.isEmpty()) {
			return false;
		}
		Pokemon toAttack = maybeToAttack.get(); 
		Pokemon isAttacking = maybeIsAttacking.get();
		Integer remaining = toAttack.getRemainingHp() - isAttacking.getAttack();
		remaining = remaining > 0 ? remaining : 0;
		toAttack.setRemainingHp(remaining);
		return true;
	} 
	
	public List<Pokemon> all(){
		return this.repository.findAll();	
	}
	
	public Optional<Pokemon> find(Long id) {
		return this.repository.findById(id);
	}
	
	public boolean delete(Long id) { 
		Optional<Pokemon> maybePokemon = this.find(id);
		if(maybePokemon.isEmpty()) { 
			return false;
		}
		this.repository.delete(maybePokemon.get());
		return true;
	}

}
