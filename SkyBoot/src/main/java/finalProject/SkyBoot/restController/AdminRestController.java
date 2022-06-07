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
import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.JsonViews.modifLogin;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.service.ArbreInProgressService;
import finalProject.SkyBoot.service.ArbreService;
import finalProject.SkyBoot.service.NodeService;
import finalProject.SkyBoot.service.UserService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ArbreService arbreService;
	
	@Autowired
	private NodeService nodeService;
	
	@Autowired
	private ArbreInProgressService arbreInProgressService;

	// Page accueil d'un admin, besoin de ses infos + fonctionne
	@GetMapping("/{id}") 
	@JsonView(Common.class)
	public Admin getById(@PathVariable Long id) {
		return (Admin) userService.getById(id);
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
	@GetMapping("/selectArbre") //+ fonctionne
	@JsonView(Common.class)
	public List<Arbre> modifArbre() {
		return arbreService.getAll();
	}

	// Modif d'un arbre -> selection d'un noeud à modifier / ajouter
	// modification de son nom / royaume + fonctionne
	@PatchMapping("/modifArbre")
	@JsonView(Common.class)
	public Arbre modifArbre(@RequestBody Arbre arbre) {		
		return arbreService.update(arbre);
	}

	// Ajout Node + fonctionne
	@PostMapping("/createNode")
	@JsonView(Common.class)
	public Node createNode(@RequestBody Node node) {
		return nodeService.create(node);	
	}
	
	// Modif Node + fonctionne
	@PatchMapping("/updateNode")
	@JsonView(Common.class)
	public Node updateNode(@RequestBody Node node) {
		nodeService.update(node);
		Node nodeBase = nodeService.getById(node.getId());
		if(nodeBase.getNodeParent() != null) {
			Arbre a = arbreService.getById(nodeBase.getNodeParent().getTref().getId());
			nodeBase.setTref(a);
			nodeService.update(nodeBase);
			
			ArbreInProgress ap = arbreInProgressService.getById(nodeBase.getNodeParent().getTripRef().getId());
			nodeBase.setTripRef(ap);
		}
			
		return nodeService.update(nodeBase);
	}
	
	// Delete Node + fonctionne
	@DeleteMapping("/deleteNode/{id}")
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteNode(@PathVariable Long id) {
		nodeService.deleteById(id);
	}
	
}
