package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cosmetique")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 2)
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Cosmetic extends Item{
	
	@OneToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="COSMETIC_NODE_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
	protected Node node;
	
	public Cosmetic(){
		super();
	}
	
	public Cosmetic(String libelle, int prix)
	{
		super(libelle,prix);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	
	
}