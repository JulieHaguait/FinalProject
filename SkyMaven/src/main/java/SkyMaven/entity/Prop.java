package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prop")
public class Prop extends Item{
	@ManyToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="PROP_NODE_ID_FK"))
	protected Node node;
	private String descriptionAction;
	
	
	public Prop() {
		super();
	}
	
	public Prop(String nom, int prix, String descriptionAction)
	{
		super(nom,prix);
		this.descriptionAction = descriptionAction;
	}
	
	
	
	
}
