package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("M")
public class Masque extends Cosmetic {

	
	public Masque() {
		
	}
	
	public Masque(String libelle, int prix) {
		super(libelle, prix);
		
	}

}
