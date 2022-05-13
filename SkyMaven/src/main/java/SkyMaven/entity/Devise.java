package SkyMaven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqDevise", sequenceName="seq_devise", initialValue=100, allocationSize=1)
public class Devise {
		
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name="money_id", foreignKey=@ForeignKey(name="DEVISE_MONEY_ID_FK"))
	private Monnaie monnaie;
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

	
	
	
	
	/*
	// --- Methodes	
	public void deposer(Double depot, String type_money)
	{
		if(depot > 0) {
			switch(type_money)
			{
			case "blanche": bougieBlanche += depot;break;
			case "eden": bougieEden += depot;break;
			case "coeur": nbCoeur += depot;break;
			}
		}
		else
		{
			System.out.println("Valeur de déposit invalide, entrer un valeur positive");
		}
		
	}
	*/
	/*
	public void acheter(Node n)
	{
		int prix = n.getItem().getPrix();
		
		String type_money = "blanche";
		
		if(n.getItem() instanceof WingBuff)
		{
			type_money = "eden";
		}
		else if(n.getItem() instanceof Prop || n.getItem() instanceof Cosmetic)
		{
			type_money = "coeur";
		}
		
		if(checkSolde(prix, type_money)) {
			switch(type_money)
			{
			case "blanche": bougieBlanche -= n.getItem().getPrix();break;
			case "eden": bougieEden -= n.getItem().getPrix();break;
			case "coeur": nbCoeur -= n.getItem().getPrix();break;
			}
		}
		else
		{
			System.out.println("Pas assez de sous, c'est balo");
		}
		
	}


	public boolean checkSolde(int prix, String type_money)
	{
		boolean check = true;
		switch(type_money)
		{
		case "blanche": if(bougieBlanche < prix) {check = false;};break;
		case "eden": if(bougieEden < prix) {check = false;};break;
		case "coeur": if(nbCoeur < prix) {check = false;};break;
		}
		return check;
	}
	*/

	
	
	
}
