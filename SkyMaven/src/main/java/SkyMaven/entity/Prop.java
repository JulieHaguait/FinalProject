package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "prop")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Prop extends Item{
	
	@OneToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="PROP_NODE_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
	protected Node node;
	
	@JsonView(JsonViews.Common.class)
	private String descriptionAction;
	
	
	public Prop() {
		super();
	}
	
	public Prop(String nom, int prix, String descriptionAction)
	{
		super(nom,prix);
		this.descriptionAction = descriptionAction;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public String getDescriptionAction() {
		return descriptionAction;
	}

	public void setDescriptionAction(String descriptionAction) {
		this.descriptionAction = descriptionAction;
	}
	
	
	
	
}
