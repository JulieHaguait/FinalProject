package finalProject.SkyBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "tree")
@SequenceGenerator(name = "seqTree", sequenceName = "seq_tree", initialValue = 1, allocationSize = 1)
public class Arbre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTree")
	private Long id;

	@JsonView({ JsonViews.Common.class })
	@Column(name = "name")
	private String nom;

	@JsonView(JsonViews.ArbreWithNode.class) // attention !!!!
	@OneToMany
	private Set<Node> nodes;

	// --- Constructor
	public Arbre() {
		super();
	}

	public Arbre(String nom, Realm realm) {
		this.nom = nom;

	}

	// --- Getters / Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	// -- HashCode
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
		Arbre other = (Arbre) obj;
		return Objects.equals(id, other.id);
	}

}
