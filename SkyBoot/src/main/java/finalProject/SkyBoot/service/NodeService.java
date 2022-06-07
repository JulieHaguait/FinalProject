package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.Cosmetic;
import finalProject.SkyBoot.entity.Emote;
import finalProject.SkyBoot.entity.HeartBuying;
import finalProject.SkyBoot.entity.MusicSheet;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.Prop;
import finalProject.SkyBoot.entity.Spell;
import finalProject.SkyBoot.entity.WingBuff;
import finalProject.SkyBoot.exception.NodeException;
import finalProject.SkyBoot.repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	private NodeRepository nodeRepository;

	@Autowired
	private CosmeticService cosService;

	@Autowired
	private ItemService itemService;

	public List<Node> getAllByArbre(Arbre arbre) {
		return nodeRepository.findByTref(arbre);
	}

	public List<Node> getAllByTripRef(ArbreInProgress arbre) {
		return nodeRepository.findByTripRef(arbre);
	}

	public List<Node> getAllByTripProgress(ArbreInProgress arbre) {
		return nodeRepository.findByTripProgress(arbre);
	}

	public Node getById(Long id) {
		return nodeRepository.findById(id).orElseThrow(NodeException::new);
	}

	public Node create(Node node) {
		return nodeRepository.save(node);
	}

	public Node update(Node node) {
		return nodeRepository.save(node);
	}

	public void delete(Node nodeSent) {
		nodeSent.setTref(null);
		nodeSent.setTripProgress(null);
		nodeSent.setTripRef(null);
		
		Node node = nodeRepository.findById(nodeSent.getId()).orElseThrow();

		if (node.getCosmetic() != null) {
			Cosmetic cos = cosService.getById(node.getCosmetic().getId());
			cos.setNode(null);
			cosService.update(cos);
			node.setCosmetic(null);
		}

		if (node.getMusicSheet() != null) {
			MusicSheet mus = (MusicSheet) itemService.getById(node.getMusicSheet().getId());
			mus.setNode(null);
			itemService.update(mus);
			node.setMusicSheet(null);
		}

		if (node.getProp() != null) {
			Prop prop = (Prop) itemService.getById(node.getProp().getId());
			prop.setNode(null);
			itemService.update(prop);
			node.setProp(null);
		}

		if (node.getSpell() != null) {
			Spell spell = (Spell) itemService.getById(node.getSpell().getId());
			spell.setNode(null);
			itemService.update(spell);
			node.setSpell(null);
		}

		if (node.getEmote() != null) {
			Emote emote = (Emote) itemService.getById(node.getEmote().getId());
			emote.setNode(null);
			itemService.update(emote);
			node.setEmote(null);
		}

		if (node.getWingBuff() != null) {
			WingBuff wing = (WingBuff) itemService.getById(node.getWingBuff().getId());
			wing.setNode(null);
			itemService.update(wing);
			node.setWingBuff(null);
		}

		if (node.getHeartBuying() != null) {
			HeartBuying heart = (HeartBuying) itemService.getById(node.getHeartBuying().getId());
			heart.setNode(null);
			itemService.update(heart);
			node.setHeartBuying(null);
		}

		nodeRepository.save(node);
		nodeRepository.delete(nodeSent);
	}

	public void deleteById(Long id) {
		Node node = new Node();
		node.setId(id);
		delete(node);
	}

}
