package finalProject.SkyBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "heart_buying")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class HeartBuying extends Item{

	@OneToOne
	@JoinColumn(name = "node_ref_id", foreignKey = @ForeignKey(name = "HEARTBUYING_NODE_REF_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
	private NodeRef nodeRef;


	// --- Constructor
	public HeartBuying() {
		super();
	}
	public HeartBuying(String libelle, int prix) {
		super(libelle, prix);
	}
	
	public NodeRef getNodeRef() {
		return nodeRef;
	}
	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

}
