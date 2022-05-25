package finalProject.SkyBoot.restController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithNodeBought;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithRealm;
import finalProject.SkyBoot.entity.JsonViews.ArbreWithNode;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.service.ArbreInProgressService;
import finalProject.SkyBoot.service.ArbreService;
import finalProject.SkyBoot.service.NodeService;

@RestController
@RequestMapping("/api/boutique")
public class ArbreRestController {

	@Autowired
	private ArbreInProgressService tripService;
	@Autowired
	private ArbreService arbreService;
	@Autowired
	private NodeService nodeService;

	
	//@JsonView(Common.class) // ?// pas besoin de JSonView :)
	@GetMapping("") // page d'accueil de la boutique avec les noms des royaumes
		public Realm[] listRealms() {
		return Realm.values();
	}

	
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
		// on recommence !!!
		
		
		//plus besoin de la suite !
		
		ArbreInProgress trip = tripService.getByIdWithNodes(id);
		Long idTref = trip.getTref().getId();
		List<Object> pourReturn = new ArrayList<Object>();
		Collections.addAll(pourReturn, trip, arbreService.getByIdWithNodes(idTref));
		return pourReturn;
		// return [trip, arbreService.getByIdWithNodes(idTref)];
	}/// -------------HELP OLIVIER (on veut deux listes XD)
	//----------------REPONSE : CREER UNE CLASSE SUPPLEMENTAIRE !!! YOUPI

}
