package finalProject.SkyBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="seqDevise", sequenceName="seq_devise", initialValue=100, allocationSize=1)
public class Devise {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDevise")
	@JsonView(JsonViews.Common.class)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="money_id", foreignKey=@ForeignKey(name="DEVISE_MONEY_ID_FK"))
	@JsonView(JsonViews.Common.class)
	private Monnaie monnaie;
	
	@JsonView(JsonViews.Common.class)
	private double quantite;
	
	// --- Constructeur
	public Devise() {

	}
	
	// --- Getters / Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Monnaie getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(Monnaie monnaie) {
		this.monnaie = monnaie;
	}


	public double getQuantite() {
		return quantite;
	}


	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
}
