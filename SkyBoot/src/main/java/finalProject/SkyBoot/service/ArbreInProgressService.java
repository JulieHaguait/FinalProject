package finalProject.SkyBoot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.repository.ArbreInProgressRepository;

@Service
public class ArbreInProgressService {
@Autowired 
private ArbreInProgressRepository tripRepository;

@Autowired
private NodeService nodeService;


	public List<ArbreInProgress> getAll() {
		return tripRepository.findAll();
	}
	public ArbreInProgress getById(Long id) {
		return tripRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public ArbreInProgress getByIdWithNodes(Long id) {
		return tripRepository.findByIdWithNodes(id).orElseThrow(RuntimeException::new);
	}
	
	
	
	
	public ArbreInProgress getByIdWithNodesWithNodesRef(Long id) {
		return tripRepository.findByIdWithNodesWithNodesRef(id).orElseThrow(RuntimeException::new);
	}
	
	public List<ArbreInProgress> getByRealm(String realm) {
		Realm realmEnum=Realm.valueOf(realm);
		return tripRepository.findByRealm(realmEnum);
	}

	public void create(ArbreInProgress trip) {
		tripRepository.save(trip);
	}

	public ArbreInProgress update(ArbreInProgress trip) {
		return tripRepository.save(trip);
	}
	
	public void deleteById(Long id) {
		ArbreInProgress trip = new ArbreInProgress();
		trip.setId(id);
		//trip.setSkyKid(null);
		trip.setTref(null);
		
		if(trip.getNodeBought() != null) {
			Set <Node> nodeBoughts = trip.getNodeBought();
			for(Node node : nodeBoughts) {
	            nodeService.deleteById(node.getId());
			}
		}
		
		if(trip.getNodeRef() != null) {
			Set<Node> nodeRefs = trip.getNodeRef();
			for (Node nodeRef : nodeRefs) {
				nodeRef.setTripRef(null);
			}
		}

		tripRepository.delete(trip);
	}
}