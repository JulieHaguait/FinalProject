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
	
	
	public Equipment update(Item item) {
		if(item instanceof Prop) {
			return equipmentRepository.save(item);
		}
		return equipmentRepository.save((Cosmetic) item);
	}
	
	
	
}
