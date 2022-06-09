package finalProject.SkyBoot.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonView;

import finalProject.SkyBoot.entity.JsonViews.Common;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class Item {

	// --- Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	@Column(name = "id")
	@JsonView({ Common.class })
	protected Long id;
	@Column(name="tag")
	@JsonView({ Common.class })
	protected String libelle;
	@Column(name = "price")
	@JsonView({ Common.class })
	protected int prix;
	
	@OneToOne(mappedBy = "item")
	protected NodeRef nodeRef;

	@OneToOne
	@JoinColumn(name = "monnaie_id", foreignKey = @ForeignKey(name = "ITEM_MONNAIE_ID_FK"))
	private Monnaie monnaie;
	


	// --- Constructeurs
	public Item(String libelle, int prix) {
		this.libelle = libelle;
		this.prix = prix;
	}

	public Item() {
		super();
	}

	// --- Getters / Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

	public Monnaie getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(Monnaie monnaie) {
		this.monnaie = monnaie;
	}

	// --- hashCode
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}

}
