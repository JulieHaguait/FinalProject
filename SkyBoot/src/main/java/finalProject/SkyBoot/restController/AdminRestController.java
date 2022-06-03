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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
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

	// Page accueil d'un admin, besoin de ses infos
	@GetMapping("/{id}")
	@JsonView(Common.class)
	public Admin getById(@PathVariable Long id) {
		return (Admin) userService.getById(id);
	}

	// Page modification d'un utilisateur
	@GetMapping("/modifUser")
	@JsonView(Common.class)
	public List<SkyKid> affUser() {
		return userService.getAllSkyKid();
	}

	// Modification d'un SkyKid (login) si inapproprié
	@PatchMapping("/modifUser")
	@JsonView(Common.class)
	public User modifUser(@PathVariable SkyKid skyKid) {
		return userService.update(skyKid);
	}
	
	// Suppression d'un SkiKid
	@DeleteMapping("/modifUser")
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteSkykid(@PathVariable Long id) {
		userService.deleteByIdSkyKid(id);
	}
	
	// Page modification de la BDD -> selection d'un arbre
	@GetMapping("/selectArbre")
	@JsonView(Common.class)
	public List<Arbre> modifArbre() {
		return arbreService.getAll();
	}

	// Modif d'un arbre -> selection d'un noeud à modifier / ajouter
	@PostMapping("/modifArbre")
	@JsonView(Common.class)
	public Arbre modifArbre(@PathVariable Long id) {
		return arbreService.getById(id);
	}

	// Ajout Node
	@PostMapping("/updateNode")
	@JsonView(Common.class)
	public Node createNode() {
		Node n = new Node();
		return nodeService.create(n);	
	}
	
	// Modif Node
	@PatchMapping("/updateNode")
	@JsonView(Common.class)
	public Node updateNode(@PathVariable Long id) {
		return nodeService.getById(id);
	}
	
}
