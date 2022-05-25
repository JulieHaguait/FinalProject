package SkyMaven.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Admin;
import SkyMaven.entity.ArbreInProgress;
import SkyMaven.entity.Devise;
import SkyMaven.entity.Equipment;
import SkyMaven.entity.SkyKid;
import SkyMaven.entity.User;
import SkyMaven.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private ArbreInProgressService tripService;
	
	@Autowired
	private DeviseService deviseService;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public List<SkyKid> getAllSkyKid(){
		return userRepository.findAllSkyKid();
	}
	
	public List<Admin> getAllAdmin(){
		return userRepository.findAllAdmin();
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public User seConnecter(String login, String password) {
		return userRepository.seConnecter(login, password).orElseThrow(RuntimeException::new);
	}

	public void create(User user) {
		// encodage du mot de passe quand on saura faire
		// user.setPassword(fonctionEncodage(user.getPassword()));
		userRepository.save(user);
	}

	public User update(User user) {
		User userEnBase = getById(user.getId());
		userEnBase.setLogin(user.getLogin());
		return userRepository.save(userEnBase);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}

	public void deleteByIdSkyKid(Long id) {
		SkyKid user = new SkyKid();
		user.setId(id);
		//suppression en cascade de l'equipment
		Equipment e = user.getEquipement();	
		equipmentService.deleteById(e.getId());
		//suppression de toute types de monnaie associee au compte
		Set <Devise> ds = user.getDevise();
		for(Devise d : ds) {
            deviseService.delete(d);
		}
		//suppression de tous les trip associees au compte
		Set <ArbreInProgress> trips = user.getTrips();
		for(ArbreInProgress trip : trips) {
            tripService.deleteById(trip.getId());
		}
		delete(user);
	}
	
	public void deleteByIdAdmin(Long id) {
		Admin user = new Admin();
		user.setId(id);
		delete(user);
	}
		

	public SkyKid getSkyKidWithAllInfos(Long id) {
		return userRepository.findAllInfos(id).orElseThrow(RuntimeException::new);
	}
}
