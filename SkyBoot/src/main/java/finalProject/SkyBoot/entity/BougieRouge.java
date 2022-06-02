package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BR")
public class BougieRouge extends Monnaie {
	
	public BougieRouge() {
		
	}

}
