package finalProject.SkyBoot.entity;

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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "spell_slot")
@SequenceGenerator(name = "seqSpellSlot", sequenceName = "seq_spellSlot", initialValue = 1, allocationSize = 1)
public class SpellSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpellSlot")
	@JsonView(JsonViews.Common.class)
	private Long Id;
	
	@JsonView(JsonViews.Common.class)
	private int quantite;
	
	@OneToOne
	@JoinColumn(name = "spell", foreignKey = @ForeignKey(name = "EQUIPMENT_SPELL_ID_FK"))
	@JsonView(JsonViews.Common.class)
	private Spell spell;

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
	
	public Spell getSpell() {
		return spell;
	}
	
	public void setSpell(Spell spell) {
		this.spell = spell;
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
