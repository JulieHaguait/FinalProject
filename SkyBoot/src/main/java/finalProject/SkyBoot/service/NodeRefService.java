package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.exception.NodeException;
import finalProject.SkyBoot.repository.ItemRepository;
import finalProject.SkyBoot.repository.NodeRefRepository;

@Service
public class NodeRefService {

	@Autowired
	private NodeRefRepository nrRepository;
	@Autowired
	private ItemRepository itemRepository;

	public List<NodeRef> getAllBySpirit(String name) {
		return nrRepository.findBySpiritName(name);
	}

	public List<NodeRef> getAllByRealm(Realm realm) {
		return nrRepository.findByRealm(realm);
	}

	public List<NodeRef> getAllNodeEnfant(NodeRef nodeParent) {
		return nrRepository.findByNodeParent(nodeParent);
	}
	
	public List<NodeRef> getAllNodeRoot(){
		return nrRepository.findAllNodeRoot();
	}
	
	
	public List<NodeRef> getAll() {
		return nrRepository.findAll();
	}
	
	public NodeRef getById(Long id){
		return nrRepository.findById(id).orElseThrow(NodeException::new);
	}
	
	public List<NodeRef> getAllWithSpiritName() {
		return nrRepository.findAll();
	}

	public NodeRef create(NodeRef nodeRef) {
		return nrRepository.save(nodeRef);
	}
	
	public NodeRef update(NodeRef nodeRef) {
		return nrRepository.save(nodeRef);
	}
	
	public void delete(NodeRef nodeSent) {
		NodeRef nodeRef = nrRepository.findById(nodeSent.getId()).orElseThrow(NodeException::new);
		itemRepository.updateNull(nodeRef);
		nrRepository.save(nodeRef);
		nrRepository.delete(nodeSent);
	}

	public void deleteById(Long id) {
		NodeRef nodeRef = new NodeRef();
		nodeRef.setId(id);
		delete(nodeRef);
	}
}
