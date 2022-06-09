package finalProject.SkyBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Item;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.JsonViews.modifLogin;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.service.ItemService;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.UserService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private NodeRefService nrService;
	
	@Autowired
	private ItemService itemService;
	

	// Page accueil d'un admin, besoin de ses infos + fonctionne
	@GetMapping("/{id}") 
	@JsonView(Common.class)
	public SkyKid getById(@PathVariable Long id) {
		return (SkyKid) userService.getById(id);
	}

	// Page modification d'un utilisateur + fonctionne
	@GetMapping("/modifUser") 
	@JsonView(Common.class)
	public List<SkyKid> affUser() {
		return userService.getAllSkyKid();
	}

	// Modification d'un SkyKid (login) si inapproprié
	@PatchMapping("/modifUser")
	@JsonView(modifLogin.class)
	public User modifUser(@RequestBody SkyKid skyKid) {
		System.out.println("coucou");
		return userService.update(skyKid);
	}
	
	// Suppression d'un SkyKid + fonctionne
	@DeleteMapping("/deleteUser/{id}")
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteSkykid(@PathVariable Long id) {
		userService.deleteByIdSkyKid(id);
	}
	
	// Page modification de la BDD -> selection d'un arbre
	@GetMapping("/selectSpirit") //+ fonctionne
	@JsonView(Common.class)
	public List<NodeRef> selectSpirit() {
		return nrService.getAllWithSpiritName();
	}
	
	@GetMapping("/selectNodeRef")
	@JsonView(Common.class)
	public NodeRef selectNodeRef(Long id) {
		return nrService.getById(id);
	}
	
	// Modif d'un arbre -> selection d'un noeud à modifier / ajouter
	// modification de son nom / royaume + fonctionne
	@PatchMapping("/modifSpirit/{spiritName}")
	@JsonView(Common.class)
	public List<NodeRef> modifSpirit(@RequestBody NodeRef modifSpirit, @PathVariable String spiritName) {	
		List<NodeRef> nrs = nrService.getAllBySpirit(spiritName);
		for(NodeRef nr : nrs) {
			modifSpirit.getSpiritName();
			if(modifSpirit.getSpiritName() != null && modifSpirit.getSpiritName() != spiritName){
				 nr.setSpiritName(modifSpirit.getSpiritName());
				 nrService.update(nr);
			}
			if(modifSpirit.getRealm() != null && modifSpirit.getRealm() != nr.getRealm()){
				 nr.setRealm(modifSpirit.getRealm());
				 nrService.update(nr);
			}
		}	
		return nrService.getAllBySpirit(modifSpirit.getSpiritName());
	}

	// Ajout Node + fonctionne MAIS ITEM DOIT ËTRE CREER AVANT
	@PostMapping("/createNode")
	@JsonView(Common.class)
	public NodeRef createNode(@RequestBody NodeRef nodeRef) {
		// côté angular, faut obliger à avoir un item  !Required!
		return nrService.create(nodeRef);	
	}
	
	// Modif Node + fonctionne
	@PatchMapping("/updateNode/{id}")
	@JsonView(Common.class)
	public NodeRef updateNode(@RequestBody NodeRef nodeModif, @PathVariable Long id) {
		NodeRef nodeBase = nrService.getById(id);
		//Modification item du nodeRef
		if(nodeBase.getItem() != nodeModif.getItem()) {
			nodeBase.setItem(nodeModif.getItem());	
		}
		//Modification nodeParent du nodeRef
		if(nodeBase.getNodeParent().getId() != nodeModif.getNodeParent().getId()) {
			nodeBase.setNodeParent(nodeModif.getNodeParent());	
		}
			
		return nrService.update(nodeBase);
	}
	
	// Delete Node + fonctionne
	@DeleteMapping("/deleteNode/{id}")
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteNode(@PathVariable Long id) {
		nrService.deleteById(id);
	}
	
	// Ajout Item 
	@PostMapping("/createItem")
	@JsonView(Common.class)
	public Item createItem(@RequestBody Item item) {
		return itemService.create(item);	
	}
	
	// Update Item -----> à tester
	@PatchMapping("/updateItem/{id}")
	@JsonView(Common.class)
	public Item updateItem(@RequestBody Item itemModif, @PathVariable Long id) {
		Item itemBase=itemService.getById(id);
		if(itemBase.getLibelle() != itemModif.getLibelle()) {
			itemBase.setLibelle(itemModif.getLibelle());	
		}
		if(itemBase.getPrix() != itemModif.getPrix()) {
			itemBase.setPrix(itemModif.getPrix());	
		}
		return itemService.update(itemBase);
	}
	
	
	
	
}
