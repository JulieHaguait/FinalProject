package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.SpellSlot;
import finalProject.SkyBoot.repository.SpellSlotRepository;


@Service
public class SpellSlotService {
	

	@Autowired
	private SpellSlotRepository spellSlotRepository;
	
	public List<SpellSlot> getAll() {
		return spellSlotRepository.findAll();
	}

	public SpellSlot getById(Long id) {
		return spellSlotRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public SpellSlot create(SpellSlot spellSlot) {
		return spellSlotRepository.save(spellSlot);
	}

	public SpellSlot update(SpellSlot spellSlot) {
		SpellSlot ssEnBase=new SpellSlot();
		ssEnBase.setQuantite(spellSlot.getQuantite());
		ssEnBase.setSpell(spellSlot.getSpell());
		return spellSlotRepository.save(ssEnBase);
	}

	public void delete(SpellSlot spellSlot) {
		spellSlotRepository.delete(spellSlot);
	}

	public void deleteById(Long id) {
		SpellSlot spellSlot = new SpellSlot();
		spellSlot.setId(id);
		spellSlotRepository.delete(spellSlot);
	}


}
