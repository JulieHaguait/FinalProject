package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Node;
import SkyMaven.exception.NodeException;
import SkyMaven.repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	private NodeRepository nodeRepository;

	public List<Node> getAllByArbre(Long arbre) {
		return nodeRepository.findAllByArbreId(arbre);
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
		nodeRepository.delete(node);
	}

	public void deleteById(Long id) {
		Node node = new Node();
		node.setId(id);
		delete(node);
	}
	
	
}

