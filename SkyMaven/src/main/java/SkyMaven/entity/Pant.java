package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pants")
@DiscriminatorValue("P")
public class Pant extends Cosmetic {

	
	public Pant(){
		
	}
	
	public Pant(String libelle, int prix) {
		super(libelle, prix);
	}

}
