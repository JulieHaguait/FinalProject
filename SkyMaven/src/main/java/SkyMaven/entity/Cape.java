package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cape")
@DiscriminatorValue("C")
public class Cape extends Cosmetic {

	public Cape() {
		
	}
	
	public Cape(String libelle, int prix) {
		super(libelle, prix);
		
	}

}