package finalProject.SkyBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.LinkNode;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.repository.LinkNodeRepository;

@Service
public class LinkNodeService {

	@Autowired
	private LinkNodeRepository lnRepo;
	
	@Autowired
	private NodeRefService nrService;
	
	@Autowired
	private NodeService nodeService;
	
	
	public LinkNode getByRealmBySkyKidId(Long id, String realm) {
		return lnRepo.findByRealmBySkyKidId(id, Realm.valueOf(realm)).orElseThrow(RuntimeException::new);
	}
	
	public LinkNode getAllLists(Long id) {
		LinkNode ln1 = lnRepo.findRefBySkyKidId(id).orElseThrow(RuntimeException::new);
		LinkNode ln2 = lnRepo.findBoughtBySkyKidId(id).orElseThrow(RuntimeException::new);
		ln1.setAllBought(ln2.getAllBought());
		return ln1;
	}
	
	public LinkNode create(LinkNode linkNode){
		List<NodeRef> listNodeRef = new ArrayList<NodeRef>();
		listNodeRef = nrService.getAll();
		linkNode.setAllRefs(listNodeRef);
		List<Node> listNode = new ArrayList<Node>();
		List<NodeRef> listNodeRefRoot = new ArrayList<NodeRef>(); //10
		listNodeRefRoot=(nrService.getAllNodeRoot());
		for(NodeRef nr : listNodeRefRoot){
			Node n = new Node();
			n.setNodeRef(nr);
			nodeService.create(n);
			listNode.add(n);
		}
		linkNode.setAllBought(listNode);
		return lnRepo.save(linkNode);
	}
	
	public LinkNode update(LinkNode linkNode) {
		return lnRepo.save(linkNode);
	}
	
	public void delete(LinkNode linkNode) {
		lnRepo.delete(linkNode);
	}
	
}
