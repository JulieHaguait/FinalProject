package finalProject.SkyBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.service.ArbreService;
import finalProject.SkyBoot.service.NodeService;
import finalProject.SkyBoot.service.UserService;

@RestController
@RequestMapping("/api/admin")
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
	public List<SkyKid> modifUser() {
		return userService.getAllSkyKid();
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

	// Modif / ajout Node
	@PostMapping("/updateNode")
	@JsonView(Common.class) // TODO : voir la view à mettre car lien node parent
	public Node updateNode(@PathVariable(required=false) Long id) {
		// test si id existe
		if(id == null) {
			// création
			Node n = new Node();
			return nodeService.create(n);	
		}
		// update	
		return nodeService.getById(id);
	}
	
	
}
