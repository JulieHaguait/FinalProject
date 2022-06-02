package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BB")
public class BougieBlanche extends Monnaie {
	
	public BougieBlanche() {
		
	}

}
