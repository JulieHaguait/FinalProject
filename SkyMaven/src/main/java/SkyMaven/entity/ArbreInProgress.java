package SkyMaven.entity;

import java.util.Objects;
import java.util.Set;

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

@Entity
@Table(name = "tree_in_progress")
@SequenceGenerator(name = "seqTrip", sequenceName = "seq_trip", initialValue = 1, allocationSize = 1)
public class ArbreInProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTrip")
	private Long Id;
	
	private double progression;

	@OneToOne
	@JoinColumn(name = "tree_id", foreignKey = @ForeignKey(name = "TRIP_TREE_ID_FK"))
	private Arbre tref;
	
	@ManyToOne
	@JoinColumn(name = "skykid_id", foreignKey = @ForeignKey(name = "TRIP_SKYKID_ID_FK"))
	private SkyKid skyKid;
	
	private Set<Node> NodeBought;
	
	// --- Constructor
	
	public ArbreInProgress() {
		super();
	}
	
	
	// --- Getters / Setters
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public double getProgression() {
		return progression;
	}


	public void setProgression(double progression) {
		this.progression = progression;
	}


	public Arbre getTref() {
		return tref;
	}


	public void setTref(Arbre tref) {
		this.tref = tref;
	}


	public SkyKid getSkyKid() {
		return skyKid;
	}


	public void setSkyKid(SkyKid skyKid) {
		this.skyKid = skyKid;
	}


	public Set<Node> getNodeBought() {
		return NodeBought;
	}


	public void setNodeBought(Set<Node> nodeBought) {
		NodeBought = nodeBought;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArbreInProgress other = (ArbreInProgress) obj;
		return Objects.equals(Id, other.Id);
	}
	
}
