package finalProject.SkyBoot.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.repository.UserRepository;
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
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.deleteByIdSkyKid(id);
	}
	
	// S'inscrire
	@PostMapping("/inscription")
	@JsonView(Common.class)
	public User create() {
		SkyKid skyKid = new SkyKid();
		return userService.create((User)skyKid);
	}
	
	// aller sur page Gestion
	@GetMapping("/{id}/gestion")
	@JsonView(Common.class)
	public SkyKid affSkyKid(@AuthenticationPrincipal User user) {
		return (SkyKid) userService.getById(user.getId());
	}
	
	// modification du skykid -> login
	@PatchMapping("{id}/gestion")
	@JsonView(Common.class)
	public SkyKid modifSkyKid(@AuthenticationPrincipal User user) {
		return (SkyKid) userService.update(user);
	}
	
}