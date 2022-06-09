package finalProject.SkyBoot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Cape;
import finalProject.SkyBoot.entity.Cheveux;
import finalProject.SkyBoot.entity.Devise;
import finalProject.SkyBoot.entity.Equipment;
import finalProject.SkyBoot.entity.LinkNode;
import finalProject.SkyBoot.entity.Masque;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.Pant;
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
	
	@Autowired
	private NodeRefService nrService;
	
	@Autowired
	private NodeService nodeService;
	
	@Autowired
	private LinkNodeService lnService;
	
	@Autowired
	private ItemService itemService;

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
			LinkNode ln = new LinkNode();
			lnService.create(ln);
			((SkyKid) user).setEquipment(e);
			userRepository.save(user);
			ln.setSkyKid((SkyKid) user);
			((SkyKid) user).setLinkNode(ln);
			lnService.update(ln);
			
//			n_1.setNodeRef(nrService.getById(120L));
//			n_2.setNodeRef(nrService.getById(121L));
//			n_3.setNodeRef(nrService.getById(122L));
//			n_4.setNodeRef(nrService.getById(123L));			
//			nodeService.create(n_1);
//			nodeService.create(n_2);
//			nodeService.create(n_3);
//			nodeService.create(n_4);
//			Collections.addAll(listNode, n_1, n_2, n_3, n_4);
//			ln.setAllBought(listNode);
			e.setCape((Cape) itemService.getById(100L));
			e.setMasque((Masque) itemService.getById(112L));
			e.setHair((Cheveux) itemService.getById(106L));
			e.setPant((Pant) itemService.getById(116L));
			((SkyKid) user).setEquipment(e);
			equipmentService.update(e);
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
