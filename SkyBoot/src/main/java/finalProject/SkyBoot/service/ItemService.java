package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Emote;
import finalProject.SkyBoot.entity.HeartBuying;
import finalProject.SkyBoot.entity.Item;
import finalProject.SkyBoot.entity.MusicSheet;
import finalProject.SkyBoot.entity.Prop;
import finalProject.SkyBoot.entity.WingBuff;
import finalProject.SkyBoot.repository.ItemRepository;


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
	
	public List<HeartBuying> findAllHeartBuying() {
		return itemRepository.findAllHeartBuying();
	}

	public Item getById(Long id) {
		return itemRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Item create(Item item) {
		return itemRepository.save(item);
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
