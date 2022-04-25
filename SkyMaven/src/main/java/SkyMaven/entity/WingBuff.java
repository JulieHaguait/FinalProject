package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "wing_buff")

public class WingBuff extends Item {
	
	@ManyToOne
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

