package finalProject.SkyBoot.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews;
import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.service.UserService;

@RestController
@RequestMapping("/api/skykid")
@CrossOrigin(origins = "*")
public class SkyKidRestController {

	@Autowired
	private UserService userService;

	// accueil avec toutes les infos
	// vu qu'on veut afficher la completion des arbres
	// arbreInProgress + fonctionne
	@GetMapping("/{id}")
	public SkyKid getById(@PathVariable Long id, @AuthenticationPrincipal User user) {
		if (user.getId() == id) {
			return (SkyKid) userService.getById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	// page inventaire + fonctionne
	@GetMapping("/{id}/inventaire")
	public SkyKid getInventaire(@PathVariable Long id, @AuthenticationPrincipal User user) {
		if (user.getId() == id) {
			return userService.getSkyKidWithAllInfos(id);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	// Supprimer son compte
	@DeleteMapping("/{id}/gestion/delete")
	@JsonView(Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id, @AuthenticationPrincipal User user) {
		if (user.getId() == id) {
			userService.deleteByIdSkyKid(id);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	// aller sur page Gestion + fonctionne
	@GetMapping("/{id}/gestion")
	@JsonView(Common.class)
	public SkyKid affSkyKid(@PathVariable Long id, @AuthenticationPrincipal User user) {
		if (user.getId() == id) {
			return (SkyKid) userService.getById(user.getId());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	// modification du skykid -> login + fonctionne
	@PatchMapping("{id}/gestion")
	@JsonView(Common.class)
	public SkyKid modifSkyKid(@PathVariable Long id, @AuthenticationPrincipal User user, @RequestBody SkyKid skykid) {
		if (user.getId() == id) {
			return (SkyKid) userService.update(skykid);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	// pour empêcher qqun de créer un compte avec le même login que qqun d'autre
	@GetMapping("/login/{login}")
    public boolean checkLogin(@PathVariable String login) {
        return userService.checkLoginExist(login);
    }

}