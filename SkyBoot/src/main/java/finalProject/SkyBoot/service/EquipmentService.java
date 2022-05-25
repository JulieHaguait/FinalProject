package finalProject.SkyBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.SkyBoot.entity.Equipment;
import finalProject.SkyBoot.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	ItemService is;
	@Autowired
	CosmeticService cs;
	
	public Equipment create(Equipment e) {
		return equipmentRepository.save(e);
	}
	
	public Equipment update(Equipment e) {
		Equipment equipEnBase = new Equipment();
		equipEnBase.setId(e.getId());
		equipEnBase.setCape(e.getCape());
		equipEnBase.setHair(e.getHair());
		equipEnBase.setMasque(e.getMasque());
		equipEnBase.setPant(e.getPant());
		equipEnBase.setProp(e.getProp());
		
		return equipmentRepository.save(equipEnBase);
	}
	
	public void delete(Equipment e) {
		//Optional<Equipment> equipEnBase = equipmentRepository.findById(e.getId()).orElseThrow(RuntimeException::new);
		e.setCape(null);
		e.setHair(null);
		e.setMasque(null);
		e.setPant(null);
		e.setProp(null);
		equipmentRepository.delete(e);
	}
	
	public void deleteById(Long id){
		Equipment e = new Equipment();
		e.setId(id);
		delete(e);
	}
	
}
