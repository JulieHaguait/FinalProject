package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Cape;
import SkyMaven.entity.Cheveux;
import SkyMaven.entity.Cosmetic;
import SkyMaven.entity.Masque;
import SkyMaven.entity.Pant;
import SkyMaven.repository.CosmeticRepository;

@Service
public class CosmeticService {

	@Autowired
	private CosmeticRepository cosmeticRepository;

	public List<Cosmetic> getAll() {
		return cosmeticRepository.findAll();
	}

	public Cosmetic getById(Long id) {
		return cosmeticRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Cape> getAllCapes() {
		return cosmeticRepository.findAllCapes();
	}

	public List<Cheveux> getAllCheveux() {
		return cosmeticRepository.findAllCheveux();
	}

	public List<Masque> getAllMasques() {
		return cosmeticRepository.findAllMasques();
	}

	public List<Pant> getAllPants() {
		return cosmeticRepository.findAllPants();
	}

	public Cosmetic create(Cosmetic cosmetic) {
		return cosmeticRepository.save(cosmetic);
	}

	public Cosmetic update(Cosmetic cosmetic) {
		Cosmetic cosmeticEnBase = getById(cosmetic.getId());
		cosmeticEnBase.setLibelle(cosmetic.getLibelle());
		cosmeticEnBase.setPrix(cosmetic.getPrix());
		return cosmeticRepository.save(cosmeticEnBase);
	}

	public void delete(Cosmetic cosmetic) {
		cosmeticRepository.delete(cosmetic);
	}

	public void deleteById(Long id) {
		Cosmetic cosmetic = new Cosmetic();
		cosmetic.setId(id);
		cosmeticRepository.delete(cosmetic);
	}

	public void deleteByIdCape(Long id) {
		Cosmetic cosmetic = new Cape();
		cosmetic.setId(id);
		cosmeticRepository.delete(cosmetic);
	}

	public void deleteByIdCheveux(Long id) {
		Cosmetic cosmetic = new Cheveux();
		cosmetic.setId(id);
		cosmeticRepository.delete(cosmetic);
	}

	public void deleteByIdMasque(Long id) {
		Cosmetic cosmetic = new Masque();
		cosmetic.setId(id);
		cosmeticRepository.delete(cosmetic);
	}

	public void deleteByIdPant(Long id) {
		Cosmetic cosmetic = new Pant();
		cosmetic.setId(id);
		cosmeticRepository.delete(cosmetic);
	}

}
