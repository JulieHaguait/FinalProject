package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prop")
public class Prop extends Item{

	private String descriptionAction;
	
	
	public Prop() {
		
	}
	
	public Prop(String nom, int prix, String descriptionAction)
	{
		super(nom,prix);
		this.descriptionAction = descriptionAction;
	}
	
	
	
	
}
