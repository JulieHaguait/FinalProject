package finalProject.SkyBoot.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.service.UserService;
import finalProject.SkyBoot.entity.JsonViews.Common;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@Autowired
	private UserService userService;
	
	// S'inscrire
	@PostMapping("/inscription")
	@JsonView(Common.class)
	public User create() {
		SkyKid skyKid = new SkyKid();
		return userService.create((User)skyKid);
	}
	
	
	// connexion
	@GetMapping("/api/auth")
	@JsonView(Common.class)
	public User authentification(@AuthenticationPrincipal User user) {
		// pas besoin d'infos en entrée
		// dans la security config, on a besoin d'être id
		// pour venir là
		// on peut avoir une méthode qui ne fait rien,
		// on essaie juste de l'appeler
		// mais peut-être intéressant de récup notre compte
		// selon si on a besoin d'info de la bdd
		return user;
	}
}
