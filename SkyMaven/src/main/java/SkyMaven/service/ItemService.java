package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Emote;
import SkyMaven.entity.Item;
import SkyMaven.entity.MusicSheet;
import SkyMaven.entity.Prop;
import SkyMaven.entity.WingBuff;
import SkyMaven.entity.CoeurAchat;
import SkyMaven.repository.ItemRepository;


@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	public List<MusicSheet> getAllMiscSheet() {
		return itemRepository.findAllMusicSheet();
	}

	public List<Prop> findAllProp() {
		return itemRepository.findAllProp();
	}
	
	public List<Emote> findAllEmote() {
		return itemRepository.findAllEmote();
	}
	
	public List<WingBuff> findAllWingBuff() {
		return itemRepository.findAllWingBuff();
	}
	
	public List<CoeurAchat> findAllCoeurAchat() {
		return itemRepository.findAllCoeurAchat();
	}

	public Item getById(Long id) {
		return itemRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(Item item) {
		
		itemRepository.save(item);
	}

	public Item update(Item item) {
		Item itemEnBase = getById(item.getId());
		itemEnBase.setLibelle(item.getLibelle());
		itemEnBase.setPrix(item.getPrix());
		return itemRepository.save(itemEnBase);
	}

	public void delete(Item item) {
		itemRepository.delete(item);
	}



}
