package SkyMaven.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "spell_slot")
@SequenceGenerator(name = "seqSpellSlot", sequenceName = "seq_spellSlot", initialValue = 1, allocationSize = 1)
public class SpellSlot {

	private int quantite;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpellSlot")
	private Long Id;


	public SpellSlot() {
	}
	public SpellSlot(int quantite) {
		this.quantite=quantite;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
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
		SpellSlot other = (SpellSlot) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	
	
}
