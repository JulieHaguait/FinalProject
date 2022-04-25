package SkyMaven.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "spirit")
@SequenceGenerator(name = "seqSpirit", sequenceName = "seq_spirit", initialValue = 1, allocationSize = 1)
public class Esprit {

	// --- Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpirit")
	private Long id;
	@Column(name = "name")
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private Realm realm;
	
	@OneToOne
	@JoinColumn(name = "tree_id", foreignKey = @ForeignKey(name = "SPIRIT_TREE_ID_FK"))
	private Arbre arbre;
	
	// --- Constructor
	
	public Esprit() {
		
	}
	
	public Esprit(Long id, String nom, Realm realm)
	{
		this.nom = nom;
		this.realm = realm;
	}

	// --- Getters / Setters
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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
		Esprit other = (Esprit) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
