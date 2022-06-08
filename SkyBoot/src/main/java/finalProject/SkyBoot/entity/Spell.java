package finalProject.SkyBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="spell")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Spell extends Item{
	
	@JsonView(JsonViews.Common.class)
	private int level;

	@JsonView(JsonViews.Common.class)
	private String descriptionAction;
	
	@OneToOne
	@JoinColumn(name = "node_ref_id", foreignKey = @ForeignKey(name = "SPELL_NODE_REF_ID_FK"))
	@JsonView(JsonViews.Common.class)
	private NodeRef nodeRef;
	
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

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}
	

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public Spell randomSpell()
	{
		// TODO récup un sort random dans la table des sorts disponibles !
		Spell spell = new Spell(libelle, prix, descriptionAction);
		return spell;
	}
	
	
	
	
	
	
	
}
