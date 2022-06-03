package finalProject.SkyBoot.restController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithNodeBoughtWithNodeRef;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithRealm;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.service.ArbreInProgressService;

@RestController
@RequestMapping("/api/boutique")
@CrossOrigin(origins = "*")
public class ArbreRestController {

	@Autowired
	private ArbreInProgressService tripService;

	
	//@JsonView(Common.class) // ?// pas besoin de JSonView :)
	@GetMapping("") // page d'accueil de la boutique avec les noms des royaumes
		public Realm[] listRealms() {
		return Realm.values();
	}

	
	@JsonView({ArbreInProgressWithRealm.class})
	@GetMapping("/{realm}")
	public List<ArbreInProgress> getConstellation(@PathVariable String realm) {
		return tripService.getByRealm(realm);
	}

	
	@GetMapping("/{realm}/{id}")
	@JsonView({ ArbreInProgressWithNodeBoughtWithNodeRef.class })
	public ArbreInProgress getNodes(@PathVariable String realm, @PathVariable Long id) {
		ArbreInProgress trip = tripService.getByIdWithNodesWithNodesRef(id);
		return trip;
	}

}
