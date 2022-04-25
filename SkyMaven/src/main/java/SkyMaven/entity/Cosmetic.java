package SkyMaven.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cosmetique")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 2)
public class Cosmetic extends Item{
	@ManyToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="COSMETIC_NODE_ID_FK"))
	protected Node node;
	
	public Cosmetic(){
		super();
	}
	
	public Cosmetic(String libelle, int prix)
	{
		super(libelle,prix);
	}


	
	
	
	
	
	public void seChanger(Cosmetic c)
	{
		// if(c instance of Cape)
		// armoire.getCapeActuel() = (Cape) c
	}
	
	
	
	
	

}