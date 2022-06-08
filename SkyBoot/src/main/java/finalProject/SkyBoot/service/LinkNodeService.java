package finalProject.SkyBoot.service;

import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.LinkNode;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.repository.LinkNodeRepository;

@Service
public class LinkNodeService {

	private LinkNodeRepository lnRepo;
	
	public LinkNode getBySkyKidId(Long id) {
		return lnRepo.findBySkyKidId(id).orElseThrow(RuntimeException::new);
	}
	
	public LinkNode getByRealmBySkyKidId(Long id, String realm) {
		return lnRepo.findByRealmBySkyKidId(id, Realm.valueOf(realm)).orElseThrow(RuntimeException::new);
	}
	
}
