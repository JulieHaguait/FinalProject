package finalProject.SkyBoot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Cape;
import finalProject.SkyBoot.entity.Devise;
import finalProject.SkyBoot.entity.Equipment;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.User;
import finalProject.SkyBoot.repository.AdminRepository;
import finalProject.SkyBoot.repository.SkyKidRepository;
import finalProject.SkyBoot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SkyKidRepository skykidRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DeviseService deviseService;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public List<SkyKid> getAllSkyKid() {
		return skykidRepository.findAllSkyKid();
	}

	public List<Admin> getAllAdmin() {
		return adminRepository.findAllAdmin();
	}

	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public User seConnecter(String login, String password) {
		return userRepository.seConnecter(login, password).orElseThrow(RuntimeException::new);
	}

	public User create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		if (user instanceof SkyKid) {
			Equipment e = equipmentService.create(new Equipment());
			Node n_1 = new Node();
			Node n_2 = new Node();
			Node n_3 = new Node();
			Node n_4 = new Node();
//			n_1.setSkyKid((SkyKid) user);
//			n_1.setNodeRef(nodeCape);
//			n_2.setSkyKid((SkyKid) user);
//			n_2.setNodeRef(nodePant);
//			n_3.setSkyKid((SkyKid) user);
//			n_3.setNodeRef(nodeCheveux);
//			n_4.setSkyKid((SkyKid) user);
//			n_4.setNodeRef(nodeMasque);
//
//			nodeService.create(n_1);
//			nodeService.create(n_2);
//			nodeService.create(n_3);
//			nodeService.create(n_4);
//			((SkyKid) user).setEquipment(e);

			// lui donner les premiers noeuds de chaque arbre
		}

		return userRepository.save(user);
	}

	public User update(User user) {
		User userEnBase = getById(user.getId());
		System.out.println(userEnBase.getLogin());
		System.out.println(user.getLogin());
		userEnBase.setLogin(user.getLogin());
		return userRepository.save(userEnBase);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public void deleteByIdSkyKid(Long id) {
		SkyKid user = (SkyKid) userRepository.findById(id).orElseThrow();

		// suppression en cascade de l'equipment

		if (user.getEquipment() != null) {
			equipmentService.deleteById(user.getEquipment().getId());
		}

		// suppression de toute types de monnaie associee au compte
		Set<Devise> ds = user.getDevise();
		for (Devise d : ds) {
			deviseService.delete(d);
		}

		delete(user);
	}

	public void deleteByIdAdmin(Long id) {
		Admin user = new Admin();
		user.setId(id);
		delete(user);
	}

	public SkyKid getSkyKidWithAllInfos(Long id) {
		return skykidRepository.findAllInfos(id).orElseThrow(RuntimeException::new);
	}

	public User getByLogin(String login) {
		return userRepository.findByLogin(login).orElseThrow(RuntimeException::new);
	}

	public boolean checkLoginExist(String login) {
		return userRepository.findByLogin(login).isPresent();
	}
}
