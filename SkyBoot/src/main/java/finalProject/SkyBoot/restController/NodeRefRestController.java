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
import finalProject.SkyBoot.entity.LinkNode;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.service.LinkNodeService;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.NodeService;

@RestController
@RequestMapping("/api/skykid/boutique")// id du skykid dans l'url ???
@CrossOrigin(origins = "*")
public class NodeRefRestController {

	@Autowired
	private LinkNodeService lnService;

	@JsonView(Common.class) // ?// pas besoin de JSonView :)
	@GetMapping("") // page d'accueil de la boutique avec les noms des royaumes
	public Realm[] listRealms() {
		return Realm.values();
	}
	
	//------------> Achat !!!
	@JsonView({ Common.class })
	@GetMapping("/{id}/{realm}")
	public LinkNode getConstellations(@PathVariable (name="realm") String realm, @PathVariable (name="id") Long id) {
		return lnService.getByRealmBySkyKidId(id, realm);
	}
	
	

}
