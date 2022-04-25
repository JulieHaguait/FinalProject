package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "emote")
public class Emote extends Item {
	
	private int level;
	
	@ManyToOne
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "EMOTE_NODE_ID_FK"))
	private Node node;
	
//Constructeur	
	
	public Emote()
	{
		super();
	}
	
	
	public Emote(String libelle, int niveau)
	{
		super(libelle, niveau);
	}

	public Emote(String libelle, int prix, int niveau)
	{
		super(libelle, prix);
		this.niveau = niveau;
	}

// getters & setters
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
    



// Methode





// ToString

}
