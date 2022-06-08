package finalProject.SkyBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wing_buff")

public class WingBuff extends Item {
	
	@OneToOne
	@JoinColumn(name = "node_ref_id", foreignKey = @ForeignKey(name = "WINGBUFF_NODE_REF_ID_FK"))
	private NodeRef nodeRef;

	public WingBuff()
	{
		super();
	}
	
	public WingBuff(int prix)
	{
		super("WingBuff",prix);
	}

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}
	
}

