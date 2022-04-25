package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hair_accessory")
@DiscriminatorValue("HA")
public class AccessoireCheveux extends Cosmetic {

	
	
	public AccessoireCheveux() {
		
	}
	
	public AccessoireCheveux(String libelle, int prix) {
		super(libelle, prix);
	}

}
