package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name="spell")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Spell extends Item{

	private String descriptionAction;
	
	@OneToOne
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "SPELL_NODE_ID_FK"))
	private Node node;
	
	public Spell(String libelle, int prix, String descriptionAction)
	{
		super(libelle, prix);
		this.descriptionAction = descriptionAction;	
	}
	
	
	public Spell() {
		super();
	}

	public String getDescriptionAction() {
		return descriptionAction;
	}

	public void setDescriptionAction(String descriptionAction) {
		this.descriptionAction = descriptionAction;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Spell randomSpell()
	{
		// TODO récup un sort random dans la table des sorts disponibles !
		Spell spell = new Spell(libelle, prix, descriptionAction);
		return spell;
	}
	
	
	
	
	
	
	
}
