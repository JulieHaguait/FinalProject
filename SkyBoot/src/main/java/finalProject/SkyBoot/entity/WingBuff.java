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
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "WINGBUFF_NODE_ID_FK"))
	private Node node;

	public WingBuff()
	{
		super();
	}
	
	public WingBuff(int prix)
	{
		super("WingBuff",prix);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
}

