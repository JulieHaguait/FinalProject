package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hair_accessory")
@DiscriminatorValue("HA")
public class HairAccessory extends Cosmetic {

	
	
	public HairAccessory() {
		
	}
	
	public HairAccessory(String libelle, int prix) {
		super(libelle, prix);
	}

}
