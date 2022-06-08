package finalProject.SkyBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.entity.Node;

import finalProject.SkyBoot.exception.NodeException;
import finalProject.SkyBoot.repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	private NodeRepository nodeRepository;

	public List<Node> getAllBySpirit(String name) {
		return nodeRepository.findBySpirit(name);
	}

	public List<Node> getAllByRealm(Realm realm) {
		return nodeRepository.findByRealm(realm);
	}

	public Optional<Node> getByNodeRefId(Long id) {
		return nodeRepository.findByNodeRefId(id);
	}
	
	public List<Node> getBySkyKidId(Long id) {
		return nodeRepository.findBySkyKidId(id);
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

	public void delete(Node node) {
		node.setNodeRef(null);
		nodeRepository.save(node);
		nodeRepository.delete(node);
	}

	public void deleteById(Long id) {
		Node node = new Node();
		node.setId(id);
		delete(node);
	}

}
