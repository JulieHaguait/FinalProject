package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Spell;
import finalProject.SkyBoot.repository.SpellRepository;


@Service
public class SpellService {
	

	@Autowired
	private SpellRepository spellRepository;
	
	public List<Spell> getAll() {
		return spellRepository.findAll();
	}

	public Spell getById(Long id) {
		return spellRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Spell create(Spell Spell) {
		return spellRepository.save(Spell);
	}

	public Spell update(Spell spell) {
		Spell spellEnBase = getById(spell.getId());
		spellEnBase.setLibelle(spell.getLibelle());
		spellEnBase.setNodeRef(spell.getNodeRef());
		spellEnBase.setPrix(spell.getPrix()); 
		return spellRepository.save(spell);
	}

	public void delete(Spell Spell) {
		spellRepository.delete(Spell);
	}

	public void deleteById(Long id) {
		Spell spell = new Spell();
		spell.setId(id);
		spellRepository.delete(spell);
	}


}
