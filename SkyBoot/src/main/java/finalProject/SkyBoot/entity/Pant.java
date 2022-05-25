package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Pant extends Cosmetic {

	public Pant(){
		
	}
	
	public Pant(String libelle, int prix) {
		super(libelle, prix);
	}

}
