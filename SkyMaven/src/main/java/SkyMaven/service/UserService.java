package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Admin;
import SkyMaven.entity.SkyKid;
import SkyMaven.entity.User;
import SkyMaven.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
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
}
