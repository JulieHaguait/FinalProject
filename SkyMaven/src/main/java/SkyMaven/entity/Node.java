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
	
	@OneToMany(mappedBy = "musicSheet" )
	private MusicSheet musicSheet;
	@OneToMany(mappedBy = "prop")
	private Prop prop;
	@OneToMany(mappedBy = "cosmetic")
	private Cosmetic cosmetic;
	@OneToMany(mappedBy = "sort")
	private Sort sort;
	@OneToMany(mappedBy = "emote")
	private Emote emote;
	@OneToMany(mappedBy = "wingBuff")
	private WingBuff wingBuff;
	@OneToMany(mappedBy = "coeurAchat")
	@column(name="buy_heart")
	private CoeurAchat coeurAchat;
	

	// Constructeur
	public Node(Node nodeParents, Item item) {
		this.nodeParents = nodeParents;
		this.item = item;
	}
	public Node() {
		super();
	}

	// getters & setters


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
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
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
	public CoeurAchat getCoeurAchat() {
		return coeurAchat;
	}
	public void setCoeurAchat(CoeurAchat coeurAchat) {
		this.coeurAchat = coeurAchat;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	// hashCode
	
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
