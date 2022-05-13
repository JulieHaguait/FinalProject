package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("H")
public class Cheveux extends Cosmetic{

	public Cheveux() {
		
	}
	
	public Cheveux(String libelle, int prix) {
		super(libelle, prix);	
	}

}
