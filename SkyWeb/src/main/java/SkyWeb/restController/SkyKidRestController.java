package SkyWeb.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SkyMaven.entity.JsonViews;
import SkyMaven.entity.SkyKid;
import SkyMaven.service.UserService;

@RestController
@RequestMapping("/api/skykid")
public class SkyKidRestController {

	@Autowired
	private UserService userService;
	
	
	// accueil avec toutes les infos
	// vu qu'on veut afficher la completion des arbres
	// arbreInProgress
	@GetMapping("/{id}")
	@JsonView(JsonViews.SkyKidWithTripEquipment.class)
	public SkyKid getById(@PathVariable Long id) {
		return (SkyKid) userService.getById(id);
	}
	
	// page inventaire
	@GetMapping("/{id}/inventaire")
	@JsonView(JsonViews.SkyKidWithTripEquipment.class)
	public SkyKid getInventaire(@PathVariable Long id) {
		return userService.getSkyKidWithAllInfos(id);
	}
	
}