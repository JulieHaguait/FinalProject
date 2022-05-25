package finalProject.SkyBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithArbre;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithNodeBought;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithNodeBoughtWithNodeRef;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithRealm;
import finalProject.SkyBoot.entity.JsonViews.ArbreInProgressWithSkyKid;
import finalProject.SkyBoot.entity.JsonViews.Common;

@Entity
@Table(name = "tree_in_progress")
@SequenceGenerator(name = "seqTrip", sequenceName = "seq_trip", initialValue = 1, allocationSize = 1)
public class ArbreInProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTrip")
	private Long id;

	@JsonView({ Common.class })
	private double progression;

	@OneToOne
	@JoinColumn(name = "tree_id", foreignKey = @ForeignKey(name = "TRIP_TREE_ID_FK"))
	@JsonView(ArbreInProgressWithArbre.class)
	private Arbre tref;

	@ManyToOne
	@JoinColumn(name = "skykid_id", foreignKey = @ForeignKey(name = "TRIP_SKYKID_ID_FK"))
	@JsonView(ArbreInProgressWithSkyKid.class)
	private SkyKid skyKid;

	@OneToMany(mappedBy = "tripProgress")
	@JsonView({ArbreInProgressWithNodeBought.class, ArbreInProgressWithNodeBoughtWithNodeRef.class})
	private Set<Node> nodeBought;
	
	@OneToMany(mappedBy = "tripRef")
	@JsonView(ArbreInProgressWithNodeBoughtWithNodeRef.class)
	private Set<Node> nodeRef;
	
	@JsonView(ArbreInProgressWithRealm.class)
	@Enumerated(EnumType.STRING)
	private Realm realm;

	// --- Constructor
	public ArbreInProgress() {
		super();
	}

	// --- Getters / Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return nodeBought;
	}

	public void setNodeBought(Set<Node> nodeBought) {
		this.nodeBought = nodeBought;
	}
	
	public Set<Node> getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef() {
		this.nodeRef = this.tref.getNodes();
	}//on récupère la liste de noeuds du tref pour l'affichage dans la boutique !!!!!!!!!

	public Realm getRealm() {
		return realm;
	}

	public void setRealm(Realm realm) {
		this.realm = realm;
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
		ArbreInProgress other = (ArbreInProgress) obj;
		return Objects.equals(id, other.id);
	}

}
