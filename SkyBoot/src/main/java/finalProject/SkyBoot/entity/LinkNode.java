package finalProject.SkyBoot.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews.Common;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.NodeService;

@Entity
@Table(name = "linkNode")
@SequenceGenerator(name="seqLinkNode", sequenceName="seq_link_node", initialValue=100, allocationSize=1)
public class LinkNode {
// ---
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLinkNode")
	private Long id;
	
	@OneToMany(mappedBy = "linkNode")
	private List<NodeRef> allRefs;
	
	@OneToMany(mappedBy = "linkNode")
	private List<Node> allBought;
	
	@OneToOne(mappedBy = "linkNode")
	//@JsonView({ Common.class })
	private SkyKid skyKid;
	
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
		this.allRefs = allRefs;
	}

	public List<Node> getAllBought() {
		return allBought;
	}

	public void setAllBought(List<Node> allBought) {
		this.allBought = allBought;
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
