package finalProject.SkyBoot.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.NodeService;

@Entity
@SequenceGenerator(name="seqLinkNode", sequenceName="seq_link_node", initialValue=100, allocationSize=1)
public class LinkNode {
// ---
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLinkNode")
	private Long id;
	@ManyToMany
	@JoinTable(name = "nodeRef")
	private List<NodeRef> allRefs;
	@OneToMany(mappedBy = "node")
	private List<Node> allBought;
	
	@OneToOne
	@JsonView({ Common.class })
	@JoinColumn(name = "skykid_id", foreignKey = @ForeignKey(name = "LINK_NODE_SKYKID_ID_FK"))
	private SkyKid skyKid;
	
	private NodeRefService nrService;
	private NodeService nodeService;
	
	public LinkNode() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<NodeRef> getAllRefs() {
		return allRefs;
	}
	public void setAllRefs(List<NodeRef> allRefs) {
		this.allRefs = nrService.getAll();
	}
	public List<Node> getAllBought() {
		return allBought;
	}
	public void setAllBought(List<Node> allBought) {
		this.allBought = nodeService.getBySkyKidId(id);
	}
	
	public SkyKid getSkyKid() {
		return skyKid;
	}
	
	public void setSkyKid(SkyKid skyKid) {
		this.skyKid = skyKid;
	}

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
		LinkNode other = (LinkNode) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
