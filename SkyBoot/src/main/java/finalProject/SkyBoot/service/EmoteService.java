package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Emote;
import finalProject.SkyBoot.repository.EmoteRepository;


@Service
public class EmoteService {

	@Autowired
	private EmoteRepository emoteRepository;
	
	public List<Emote> getAll() {
		return emoteRepository.findAll();
	}

	public Emote getById(Long id) {
		return emoteRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Emote create(Emote emote) {
		return emoteRepository.save(emote);
	}

	public Emote update(Emote emote) {
		Emote emoteEnBase = getById(emote.getId());
		emoteEnBase.setLevel(emote.getLevel());
		emoteEnBase.setLibelle(emote.getLibelle());
		emoteEnBase.setNode(emote.getNode());
		emoteEnBase.setPrix(emote.getPrix()); 
		return emoteRepository.save(emote);
	}

	public void delete(Emote emote) {
		emoteRepository.delete(emote);
	}

	public void deleteById(Long id) {
		Emote emote = new Emote();
		emote.setId(id);
		emoteRepository.delete(emote);
	}


}
