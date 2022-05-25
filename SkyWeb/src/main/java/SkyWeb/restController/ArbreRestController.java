package SkyWeb.restController;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SkyMaven.entity.ArbreInProgress;
import SkyMaven.entity.JsonViews;
import SkyMaven.entity.JsonViews.ArbreInProgressWithNodeBought;
import SkyMaven.entity.JsonViews.ArbreInProgressWithRealm;
import SkyMaven.entity.JsonViews.ArbreWithNode;
import SkyMaven.entity.JsonViews.Common;
import SkyMaven.entity.Realm;
import SkyMaven.service.ArbreInProgressService;
import SkyMaven.service.ArbreService;
import SkyMaven.service.NodeService;

@RestController
@RequestMapping("/api/boutique")
public class ArbreRestController {

	@Autowired
	private ArbreInProgressService tripService;
	@Autowired
	private ArbreService arbreService;
	@Autowired
	private NodeService nodeService;

	
	@JsonView(Common.class) // ?
	@GetMapping("") // page d'accueil de la boutique avec les noms des royaumes
	// vue json qu'on veut
	public Realm[] listRealms() {
		return Realm.values();
	}// -------------Demander à Olivier parceque c'est un Enum et on sait pas !

	
	@JsonView({ArbreInProgressWithRealm.class})
	@GetMapping("/{realm}") // liste de tous les arbres/trip -> pas encore, liste des arbres de la
							// constellation
	public List<ArbreInProgress> getConstellation(@PathVariable String realm) {
		return tripService.getByRealm(realm);
	}
	// c'est bon !

	
	@GetMapping("/{realm}/{id}")
	@JsonView({ ArbreInProgressWithNodeBought.class, ArbreWithNode.class })
	public List<Object> getNodes(@PathVariable String realm, @PathVariable Long id) {
		ArbreInProgress trip = tripService.getByIdWithNodes(id);
		Long idTref = trip.getTref().getId();
		List<Object> pourReturn = new ArrayList<Object>();
		Collections.addAll(pourReturn, trip, arbreService.getByIdWithNodes(idTref));
		return pourReturn;
		// return [trip, arbreService.getByIdWithNodes(idTref)];
	}/// -------------HELP OLIVIER (on veut deux listes XD)

}
