package finalProject.SkyBoot.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import finalProject.SkyBoot.entity.JsonViews.Common;

@Entity
@Table(name = "Node")
@SequenceGenerator(name = "seqNode", sequenceName = "seq_Node", initialValue = 100, allocationSize = 1)
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqNode")
	@JsonView({ Common.class })
	private Long id;
	
	@ManyToOne
	@JsonView({ Common.class })
	@JoinColumn(name = "node_ref", foreignKey = @ForeignKey(name = "NODE_NODE_REF_ID_FK"))
	private NodeRef nodeRef;
	
	@ManyToOne
	private LinkNode linkNode;
	
	
	
	
	// --- Constructeur
	public Node() {
	}

	public Node(NodeRef nodeRef) {
		super();
		this.nodeRef = nodeRef;
	}


	// --- Getters & setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
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
		Node other = (Node) obj;
		return Objects.equals(id, other.id);
	}

}
