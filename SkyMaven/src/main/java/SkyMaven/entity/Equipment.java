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
@Table(name = "equipment")
@SequenceGenerator(name = "seqEquipment", sequenceName = "seq_equipment", initialValue = 1, allocationSize = 1)
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquipment")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cape", foreignKey = @ForeignKey(name = "EQUIPMENT_CAPE_ID_FK"))
	private Cape cape;
	@OneToOne
	@JoinColumn(name = "mask", foreignKey = @ForeignKey(name = "EQUIPMENT_MASK_ID_FK"))
	private Masque masque;
	@OneToOne
	@JoinColumn(name = "pant", foreignKey = @ForeignKey(name = "EQUIPMENT_PANT_ID_FK"))
	private Pant pant;
	@OneToOne
	@JoinColumn(name = "hair", foreignKey = @ForeignKey(name = "EQUIPMENT_HAIR_ID_FK"))
	private Cheveux hair;
	@OneToOne
	@JoinColumn(name = "prop", foreignKey = @ForeignKey(name = "EQUIPMENT_PROP_ID_FK"))
	private Prop prop;
	
	// --- Constructor
	public Equipment() {
		super();
	}
	
	// --- Getters / Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cape getCape() {
		return cape;
	}

	public void setCape(Cape cape) {
		this.cape = cape;
	}

	public Masque getMasque() {
		return masque;
	}

	public void setMasque(Masque masque) {
		this.masque = masque;
	}

	public Pant getPant() {
		return pant;
	}

	public void setPant(Pant pant) {
		this.pant = pant;
	}

	public Cheveux getHair() {
		return hair;
	}

	public void setHair(Cheveux hair) {
		this.hair = hair;
	}

	public Prop getProp() {
		return prop;
	}

	public void setProp(Prop prop) {
		this.prop = prop;
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
		Equipment other = (Equipment) obj;
		return Objects.equals(id, other.id);
	}	

}
