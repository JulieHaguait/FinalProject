package SkyMaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Cosmetic;
import SkyMaven.entity.Equipment;
import SkyMaven.entity.Item;
import SkyMaven.entity.Prop;
import SkyMaven.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	ItemService is;
	@Autowired
	CosmeticService cs;
	
	
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
	
	
	
}
