package finalProject.SkyBoot.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.service.UserService;

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
	
	// Supprimer son compte
	@DeleteMapping("/{id}/gestion")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.deleteByIdSkyKid(id);
	}
	
	//@PostMapping("/inscription")
	
	
	//@GetMapping("/{id}/gestion")
	// Patch
	
	
	
	// modif login
	// modif nom / pseudo
	
}