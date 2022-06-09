package finalProject.SkyBoot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.Cape;
import finalProject.SkyBoot.entity.Cheveux;
import finalProject.SkyBoot.entity.Coeur;
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
	
	@Autowired
	private MonnaieService monnaieService;

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
			
			e.setCape((Cape) itemService.getById(100L));
			e.setMasque((Masque) itemService.getById(112L));
			e.setHair((Cheveux) itemService.getById(106L));
			e.setPant((Pant) itemService.getById(116L));
			((SkyKid) user).setEquipment(e);
			equipmentService.update(e);
					
			Devise devise1 = new Devise();
			devise1.setQuantite(0);
			devise1.setMonnaie(monnaieService.getById(100L));
			devise1.setSkykid((SkyKid) user);
			deviseService.create(devise1);
			
			Devise devise2 = new Devise();
			devise2.setQuantite(0);
			devise2.setMonnaie(monnaieService.getById(101L));
			devise2.setSkykid((SkyKid) user);
			deviseService.create(devise2);

			
			Devise devise3 = new Devise();
			devise3.setQuantite(0);
			devise3.setMonnaie(monnaieService.getById(102L));
			devise3.setSkykid((SkyKid) user);
			deviseService.create(devise3);

			
			Set<Devise> argent = new HashSet<Devise>();	
			Collections.addAll(argent, devise1, devise2, devise3);
			((SkyKid) user).setDevise(argent);
	
		}

		return userRepository.save(user);
	}

	public User update(User user) {
		User userEnBase = getById(user.getId());
		userEnBase.setLogin(user.getLogin());
			
		if(user instanceof SkyKid) {
				
			for(Devise dBase : ((SkyKid) userEnBase).getDevise()) {
				for(Devise dNew :((SkyKid) user).getDevise() ) {
					
					if(dBase.getId() == dNew.getId()) {
						if(dBase.getQuantite() != dNew.getQuantite()) {
							// update la table Devise
							
							Devise dTruc = deviseService.getById(dBase.getId()).orElseThrow(RuntimeException::new);
							dTruc.setQuantite(dTruc.getQuantite() + dNew.getQuantite());
							// dTruc.setSkykid((SkyKid) userEnBase);
							// deviseService.update(dTruc);		
						}
					}	
				}
			}
		}
		
		
		
		return userRepository.save(userEnBase);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public void deleteByIdSkyKid(Long id) {
		SkyKid user = (SkyKid) userRepository.findById(id).orElseThrow();

		// suppression en cascade de l'equipment

		if (user.getEquipment() != null) {
			Long idEqu = user.getEquipment().getId();
			user.setEquipment(null);
			equipmentService.deleteById(idEqu);
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
