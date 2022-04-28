package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "emote")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Emote extends Item {
	
	private int level;
	
	@OneToOne
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "EMOTE_NODE_ID_FK"))
	private Node node;
	
	// --- Constructeur	
	
	public Emote()
	{
		super();
	}
	
	
	public Emote(String libelle, int niveau)
	{
		super(libelle, niveau);
	}

	public Emote(String libelle, int prix, int level)
	{
		super(libelle, prix);
		this.level = level;
	}

	// --- getters & setters

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
    

}
