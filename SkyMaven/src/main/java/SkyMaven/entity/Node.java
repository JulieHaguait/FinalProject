package SkyMaven.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "Node")
@SequenceGenerator(name = "seqNode", sequenceName = "seq_Node", initialValue = 100, allocationSize = 1)
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqNode")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "node_Enfants_id", foreignKey = @ForeignKey(name = "NODE_NODE_ENFANTS_ID_FK"))
	private Node nodeEnfants;
	
	@OneToOne(mappedBy = "node")
	private MusicSheet musicSheet;
	@OneToOne(mappedBy = "node")
	private Prop prop;
	@OneToOne(mappedBy = "node")
	private Cosmetic cosmetic;
	@OneToOne(mappedBy = "node")
	private Spell spell;
	@OneToOne(mappedBy = "node")
	private Emote emote;
	@OneToOne(mappedBy = "node")
	private WingBuff wingBuff;
	@OneToOne(mappedBy = "node")
	@Column(name="buy_heart")
	private HeartBuying heartBuying;
	

	// --- Constructeur
	public Node() {
		super();
	}

	// --- Getters & setters
	public Node getNodeEnfants() {
		return nodeEnfants;
	}
	
	public void setNodeEnfants(Node nodeEnfants) {
		this.nodeEnfants = nodeEnfants;
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
	
	public Spell getSort() {
		return spell;
	}
	
	public void setSort(Spell spell) {
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
	
	public HeartBuying getCoeurAchat() {
		return heartBuying;
	}
	
	public void setCoeurAchat(HeartBuying heartBuying) {
		this.heartBuying = heartBuying;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
