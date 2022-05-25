package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Cape extends Cosmetic {

	public Cape() {
		
	}
	
	public Cape(String libelle, int prix) {
		super(libelle, prix);
	}

}