package finalProject.SkyBoot.entity;

import java.util.Objects;

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

import finalProject.SkyBoot.entity.JsonViews.Boutique;
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
	@JoinColumn(name = "node_Parent_id", foreignKey = @ForeignKey(name = "NODE_NODE_PARENT_ID_FK"))
	@JsonView({Boutique.class }) //--------------> regler JsonView :)
	private Node nodeParent;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class }) // --------------> regler JsonView :)
	private MusicSheet musicSheet;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class })  // --------------> regler JsonView :)
	private Prop prop;
	
	@OneToOne(mappedBy = "node")
	 @JsonView({ Common.class }) // --------------> regler JsonView :)
	private Cosmetic cosmetic;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class }) // --------------> regler JsonView :)
	private Spell spell;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class }) //--------------> regler JsonView :)
	private Emote emote;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class })// --------------> regler JsonView :)
	private WingBuff wingBuff;
	
	@OneToOne(mappedBy = "node")
	@JsonView({ Common.class }) //--------------> regler JsonView :)
	private HeartBuying heartBuying;
	
	@ManyToOne
	@JoinColumn(name = "tref_id", foreignKey = @ForeignKey(name = "NODE_TREF_ID_FK"))
	//@JsonView({ Common.class })--------------> regler JsonView :)
	private Arbre tref;
	
	@ManyToOne
	@JoinColumn(name = "trip_progress_id", foreignKey = @ForeignKey(name = "NODE_TRIP_PROGRESS_ID_FK"))
	//@JsonView({ Common.class })--------------> regler JsonView :)
	private ArbreInProgress tripProgress;
	
	@ManyToOne
	@JoinColumn(name = "trip_ref_id", foreignKey = @ForeignKey(name = "NODE_TRIP_REF__ID_FK"))
	//@JsonView({ Common.class })--------------> regler JsonView :)
	private ArbreInProgress tripRef;
	

	// --- Constructeur
	public Node() {
		super();
	}

	// --- Getters & setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Node getNodeParent() {
		return nodeParent;
	}

	public void setNodeParent(Node nodeParent) {
		this.nodeParent = nodeParent;
	}

	public MusicSheet getMusicSheet() {
		return musicSheet;
	}

	public void setMusicSheet(MusicSheet musicSheet) {
		this.musicSheet = musicSheet;
	}

	public Prop getProp() {
		return prop;
	}

	public void setProp(Prop prop) {
		this.prop = prop;
	}

	public Cosmetic getCosmetic() {
		return cosmetic;
	}

	public void setCosmetic(Cosmetic cosmetic) {
		this.cosmetic = cosmetic;
	}

	public Spell getSpell() {
		return spell;
	}

	public void setSpell(Spell spell) {
		this.spell = spell;
	}

	public Emote getEmote() {
		return emote;
	}

	public void setEmote(Emote emote) {
		this.emote = emote;
	}

	public WingBuff getWingBuff() {
		return wingBuff;
	}

	public void setWingBuff(WingBuff wingBuff) {
		this.wingBuff = wingBuff;
	}

	public HeartBuying getHeartBuying() {
		return heartBuying;
	}

	public void setHeartBuying(HeartBuying heartBuying) {
		this.heartBuying = heartBuying;
	}

	public Arbre getTref() {
		return tref;
	}

	public void setTref(Arbre tref) {
		this.tref = tref;
	}

	public ArbreInProgress getTripProgress() {
		return tripProgress;
	}

	public void setTripProgress(ArbreInProgress tripProgress) {
		this.tripProgress = tripProgress;
	}

	public ArbreInProgress getTripRef() {
		return tripRef;
	}

	public void setTripRef(ArbreInProgress tripRef) {
		this.tripRef = tripRef;
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
