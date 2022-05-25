package finalProject.SkyBoot.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {

	// --- Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	@Column(name = "id")
	protected Long id;
	@Column(name="tag")
	protected String libelle;
	@Column(name = "price")
	protected int prix;

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
