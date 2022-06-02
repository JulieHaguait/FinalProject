package finalProject.SkyBoot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("skykid")
public class SkyKid extends User {
	
	// --- Attributs
	@OneToOne
	@JoinColumn(name="closet_id", foreignKey=@ForeignKey(name="SKYKID_CLOSET_ID_FK"))
	@JsonView(JsonViews.SkyKidWithTripEquipment.class)
	private Equipment equipment = new Equipment();
	
	@Column(name="winged_light")
	@JsonView(JsonViews.Common.class)
	private int nbEnfant = 0;
	
	@OneToMany(mappedBy="monnaie")
	@JsonView(JsonViews.Common.class)
	private Set<Devise> devise;
	
	@Column(name="wing_buff")
	@JsonView(JsonViews.Common.class)
	private int wingBuff = 0;
	
	@OneToMany(mappedBy="skyKid")
	@JsonView(JsonViews.SkyKidWithTripEquipment.class)
	private Set<ArbreInProgress> trips;
	
	
	// private Set<SkyKid> friends;
	
	// --- Constructeurs
	public SkyKid() {
		
	}
	
	// --- Getters / Setters
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public Set<Devise> getDevise() {
		return devise;
	}

	public void setDevise(Set<Devise> devise) {
		this.devise = devise;
	}

	public int getWingBuff() {
		return wingBuff;
	}

	public void setWingBuff(int wingBuff) {
		this.wingBuff = wingBuff;
	}

	public Set<ArbreInProgress> getTrips() {
		return trips;
	}


	public void setTrips(Set<ArbreInProgress> trips) {
		this.trips = trips;
	}
	
}
