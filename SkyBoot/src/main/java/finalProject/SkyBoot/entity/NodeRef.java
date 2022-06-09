package finalProject.SkyBoot.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews.Boutique;
import finalProject.SkyBoot.entity.JsonViews.Common;

@Entity
@Table(name = "nodeRef")
@SequenceGenerator(name = "seqNodeRef", sequenceName = "seq_node_ref", initialValue = 100, allocationSize = 1)
public class NodeRef {

	@Id
	@JsonView({Common.class})
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqNodeRef")
	private Long id;

	@JsonView({ Common.class })
	@Column(name = "spirit_name")
	private String spiritName;

	@JsonView(Common.class)
	@Enumerated(EnumType.STRING)
	private Realm realm;
	
	@ManyToOne
	@JoinColumn(name = "node_Parent_id", foreignKey = @ForeignKey(name = "NODE_REF_NODE_PARENT_ID_FK"))
	private NodeRef nodeParent;

	@OneToOne
	@JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "NODE_REF_ITEM_ID_FK"))
	//@JsonView({ Common.class }) // --------------> regler JsonView :)
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "link_node_id", foreignKey = @ForeignKey(name = "NODE_REF_LINK_NODE_ID_FK"))
	private LinkNode linkNode;
	
	
	// --- Constructor
	public NodeRef() {

	}

	// --- Getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		this.spiritName = spiritName;
	}

	public Realm getRealm() {
		return realm;
	}

	public void setRealm(Realm realm) {
		this.realm = realm;
	}

	public NodeRef getNodeParent() {
		return nodeParent;
	}

	public void setNodeParent(NodeRef nodeParent) {
		this.nodeParent = nodeParent;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item= item;
	}

	// --- HashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeRef other = (NodeRef) obj;
		return Objects.equals(id, other.id);
	}

}
