package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pants")
@DiscriminatorValue("P")
public class Tenue extends Cosmetic {

	
	public Tenue(){
		
	}
	
	public Tenue(String libelle, int prix) {
		super(libelle, prix);
	}

}
