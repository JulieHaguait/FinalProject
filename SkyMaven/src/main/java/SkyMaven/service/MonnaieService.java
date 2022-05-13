package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.BougieBlanche;
import SkyMaven.entity.BougieRouge;
import SkyMaven.entity.Coeur;
import SkyMaven.entity.Monnaie;
import SkyMaven.repository.MonnaieRepository;


@Service
public class MonnaieService {
	@Autowired
	private MonnaieRepository monnaieRepository;

	public List<Monnaie> getAll() {
		return monnaieRepository.findAll();
	}
	
	public List<BougieBlanche> findAllBougieBlanche() {
		return monnaieRepository.findAllBougieBlanche();
	}
	
	public List<BougieRouge> findAllBougieRouge() {
		return monnaieRepository.findAllBougieRouge();
	}
	
	public List<Coeur> findAllCoeur() {
		return monnaieRepository.findAllCoeur();
	}

	public Monnaie getById(Long id) {
		return monnaieRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(Monnaie monnaie) {
		
		monnaieRepository.save(monnaie);
	}

	public Monnaie update(Monnaie monnaie) {
		Monnaie monnaieEnBase = getById(monnaie.getId());
		monnaieEnBase.setLibelle(monnaie.getLibelle());
		return monnaieRepository.save(monnaieEnBase);
	}

	public void delete(Monnaie monnaie) {
		monnaieRepository.delete(monnaie);
	}

}
