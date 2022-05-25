package SkyMaven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Set;

@Entity
@SequenceGenerator(name="seqUser", sequenceName="seq_user", initialValue=100, allocationSize=1)
public class SkyKid extends User {
	
	// --- Attributs
	@Column(name="pseudo")
	@JsonView(JsonViews.Common.class)
	private String nom;

	@OneToOne
	@JoinColumn(name="closet_id", foreignKey=@ForeignKey(name="SKYKID_CLOSET_ID_FK"))
	@JsonView(JsonViews.SkyKidWithTripEquipment.class)
	private Equipment equipement = new Equipment();
	
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
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Equipment getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipment equipement) {
		this.equipement = equipement;
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

	
	
	// --- Méthodes
/*
	public void offrirCoeur(SkyKid s)
	{
		// tester si assez de bougie blanche
		if(this.getCompte().getBougieBlanche() < 3)
		{
			System.out.println("Tu n'as pas assez de bougie pour offrir un coeur.");
		}
		else
		{
			this.getCompte().setBougieBlanche(this.getCompte().getBougieBlanche()-3);
			s.getCompte().setNbCoeur(s.getCompte().getNbCoeur()+1);
		}

	}
	
/*	public void sendFragmentCoeur(SkyKid s)
	{
		int frag = s.getCompte().getTotalFragCoeur() + 1;
		if(frag == 60)
		{
			s.getCompte().setNbCoeur(s.getCompte().getNbCoeur()+1);
			s.getCompte().setTotalFragCoeur(0);
		}
		else
		{
			s.getCompte().setTotalFragCoeur(frag);
		}
	}
*/

/*	public void visiteRealm(String nomRealm)
	{

		int enfantsPerdus = 0;
		int enfantsRecup = 0;
		Double bBlanches = 0.0;
		Double bEdens = 0.0;
		
		if(nomRealm.equals("Eden")){
			String finishEden = saisieString("Tu es allé(e) jusqu'au bout ? oui/non");
			if(finishEden.equals("oui"))
			{
				bBlanches = saisieDouble("Combien de bougies blanches récupérées ?");
				compte.deposer(bBlanches, "blanche");
				bEdens = saisieDouble("Combien de bougies rouges récupérées ?");
				compte.deposer(bEdens, "eden");
			}
			else 
			{
				enfantsPerdus += saisieInt("(T^T) Combien d'enfants perdus ?");
				enfantsRecup += saisieInt("Combien d'enfants de lumière récupérés ?");
			}
		}
		
		else{
			System.out.println("Vous avez visité le royaume "+ nomRealm +".");
			enfantsRecup += saisieInt("Combien d'enfants de lumière récupérés ?");
			bBlanches = saisieDouble("Combien de bougies récupérées ?");		
			compte.deposer(bBlanches, "blanche");
			if(!nomRealm.equals("Aube"))
			{
				String crabbed = saisieString("Tu t'es fait crabbed ? oui/non");
				if (crabbed.equals("oui"))
				{
					enfantsPerdus += saisieInt("Avoue tu les as embêtés... Combien d'enfants perdus ?");
				}
				else
				{
					System.out.println("C'est vrai qu'ils sont pas méchants ^^");
				}
			}
			if(nomRealm.equals("Desert"))
			{
				String krilled = saisieString("Krilled ? oui/non");
				if(krilled=="oui")
				{
					enfantsPerdus += saisieInt("(T^T) Combien d'enfants perdus ?");
				}
				else
				{
					System.out.println("(0o0) Bien joué !");
				}
				
			}
			nbEnfant = nbEnfant - enfantsPerdus + enfantsRecup;
			System.out.println("C'était une belle ballade !");
		
			}	
		
		
	}*/

	
}
