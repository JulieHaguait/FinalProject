package finalProject.SkyBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "emote")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Emote extends Item {
	
	@JsonView(JsonViews.Common.class)
	private int level;
	
	@OneToOne
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "EMOTE_NODE_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
	private Node node;
	
	// --- Constructeur	
	public Emote()
	{
		super();
	}
	
	public Emote(String libelle, int level)
	{
		super(libelle, level);
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
