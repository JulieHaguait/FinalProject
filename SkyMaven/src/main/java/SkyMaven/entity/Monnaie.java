package SkyMaven.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="monnaie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Monnaie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMonnaie")
	@SequenceGenerator(name = "seqMonnaie", sequenceName = "seq_monnaie", initialValue = 100, allocationSize = 1)
	@Column(name = "id")
	@JsonView(JsonViews.Common.class)
	protected Long id;
	
	@Column(name="tag")
	@JsonView(JsonViews.Common.class)
	protected String libelle;
	
	public Monnaie() {
		super();
	}
	
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
		Monnaie other = (Monnaie) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
