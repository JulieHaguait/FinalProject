package SkyMaven.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "found_spirit")
@SequenceGenerator(name = "seqFoundSpirit", sequenceName = "seq_foundspirit", initialValue = 1, allocationSize = 1)
public class EspritTouve {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFoundSpirit")
	private Long Id;
	
	private double spiritCompletion;

	@OneToOne
	@JoinColumn(name = "tree_id", foreignKey = @ForeignKey(name = "FOUNDSPIRIT_TREE_ID_FK"))
	private Arbre arbre;
	@OneToOne
	@JoinColumn(name = "spirit_id", foreignKey = @ForeignKey(name = "FOUNDSPIRIT_SPIRIT_ID_FK"))
	private Esprit esprit;
	
	
	// --- Constructor
	
	public EspritTouve() {
		super();
	}
	
	
	// --- Getters / Setters
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public double getSpiritCompletion() {
		return spiritCompletion;
	}

	public void setSpiritCompletion(double spiritCompletion) {
		this.spiritCompletion = spiritCompletion;
	}

	public Arbre getArbre() {
		return arbre;
	}

	public void setArbre(Arbre arbre) {
		this.arbre = arbre;
	}

	public Esprit getEsprit() {
		return esprit;
	}

	public void setEsprit(Esprit esprit) {
		this.esprit = esprit;
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
		EspritTouve other = (EspritTouve) obj;
		return Objects.equals(Id, other.Id);
	}
	
}
