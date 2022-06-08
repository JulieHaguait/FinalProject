package finalProject.SkyBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithNodeBoughtWithNodeRef;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithRealm;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.NodeService;

@RestController
@RequestMapping("/api/skykid/boutique")// id du skykid dans l'url ???
@CrossOrigin(origins = "*")
public class NodeRefRestController {

	@Autowired
	private NodeRefService nrService;
	
	@Autowired
	private NodeService nodeService;

	// @JsonView(Common.class) // ?// pas besoin de JSonView :)
	@GetMapping("") // page d'accueil de la boutique avec les noms des royaumes
	public Realm[] listRealms() {
		return Realm.values();
	}
	
	
	@JsonView({ ArbreInProgressWithRealm.class })
	@GetMapping("/{realm}")
	public List<NodeRef> getConstellation(@PathVariable String realm) {
		return nrService.getAllByRealm(Realm.valueOf(realm));
	}
	
	@JsonView(Common.class)
	@GetMapping("{id}/{realm}")
	public List<Node> getConstellation(@PathVariable Long id, String realm) {
		SkyKid KidBase = new SkyKid();
		KidBase.setId(id);
		return nodeService.getAllByRealm(Realm.valueOf(realm));
	}
	
//	// Achat !!!
//	@GetMapping("/{realm}/{spiritName}")
//	//@JsonView({ ArbreInProgressWithNodeBoughtWithNodeRef.class })
//	public List<NodeRef> getNodes(@PathVariable String realm,@PathVariable String spiritName) {
//		List<NodeRef> nodesBoutique=nrService.getAllBySpirit(spiritName);
//		
//		
//		ArbreInProgress trip = tripService.getByIdWithNodesWithNodesRef(id);
//		return trip;
//	}
	
	
	
	
	
	
	
	

//	@GetMapping("/{realm}/{id}")
//	//@JsonView({ ArbreInProgressWithNodeBoughtWithNodeRef.class })
//	public ArbreInProgress getNodes(@PathVariable String realm, @PathVariable Long id) {
//		ArbreInProgress trip = tripService.getByIdWithNodesWithNodesRef(id);
//		return trip;
//	}

}
