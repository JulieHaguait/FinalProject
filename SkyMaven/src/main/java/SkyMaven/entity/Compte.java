package SkyMaven.entity;

public class Compte {
	
	private Double bougieBlanche;
	private Double bougieEden;
	private Double nbCoeur;
	// private int totalFragCoeur;
	
	// --- Constructeur
	public Compte(Double bougieBlanche, Double bougieEden, Double nbCoeur) {
		this.bougieBlanche = bougieBlanche;
		this.bougieEden = bougieEden;
		this.nbCoeur = nbCoeur;
	}

	
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
	
	
	// --- Getters / Setters
	public Double getBougieBlanche() {
		return bougieBlanche;
	}

	public void setBougieBlanche(Double bougieBlanche) {
		this.bougieBlanche = bougieBlanche;
	}

	public Double getBougieEden() {
		return bougieEden;
	}

	public void setBougieEden(Double bougieEden) {
		this.bougieEden = bougieEden;
	}

	public Double getNbCoeur() {
		return nbCoeur;
	}

	public void setNbCoeur(Double nbCoeur) {
		this.nbCoeur = nbCoeur;
	}

	// --- ToString
	@Override
	public String toString() {
		return "Compte [bougieBlanche=" + bougieBlanche + ", bougieEden=" + bougieEden + ", nbCoeur=" + nbCoeur + "]";
	}
	
	
	
}
