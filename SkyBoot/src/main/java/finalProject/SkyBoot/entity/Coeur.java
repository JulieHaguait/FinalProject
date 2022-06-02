package finalProject.SkyBoot.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Coeur extends Monnaie{

	public Coeur()
	{
		
	}
	
}
