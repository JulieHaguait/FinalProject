package finalProject.SkyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import finalProject.SkyBoot.entity.Devise;
import finalProject.SkyBoot.repository.DeviseRepository;


public class DeviseService {

	@Autowired
	private DeviseRepository deviseRepository;
	
	public List<Devise> getAll(){
		return deviseRepository.findAll();
	}
	
	public Devise getById(Long id) {
		return deviseRepository.getById(id);
	}
	
	
	public Devise create(Devise devise) {
        return deviseRepository.save(devise);
    }

    public Devise update(Devise devise) {
    	Devise deviseEnBase=new Devise();
        deviseEnBase.setQuantite(devise.getQuantite());
        deviseEnBase.setMonnaie(devise.getMonnaie());
        return deviseRepository.save(deviseEnBase);
    }
	
	public void delete(Devise devise) {
        deviseRepository.delete(devise);
    }

    public void deleteById(Long id) {
        Devise devise = new Devise();
        devise.setId(id);
        delete(devise);
    }
	

	
	
}
