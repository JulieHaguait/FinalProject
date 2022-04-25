package SkyMaven.entity;


public class SkyKid extends User implements Saisie{
	
	// --- Attributs
	
	private Integer id;
	private String nom; // Pseudo sur le site (notre app)
	// private double taille = 0; // peut aller de -2000 (Chibi) à +2000
	// private boolean chibi = false;
	private Armoire armoire = new Armoire();
	private int nbEnfant = 0;
	private Compte compte;
	private int wingBuff = 0;
	
	// --- Constructeurs
	
	public SkyKid(String nom)
	{
		this.nom = nom;
		this.compte = new Compte(0.0, 0.0, 0.0);
	}
	
	public SkyKid(String nom, double bougieBlanche, double bougieEden, double nbCoeur)
	{
		this.nom = nom;
		this.compte = new Compte(bougieBlanche, bougieEden, nbCoeur);
	}
	
	
	// --- Méthodes

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

	public void visiteRealm(String nomRealm)
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
		
		
	}
	
	// --- Getters / Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Armoire getArmoire() {
		return armoire;
	}

	public void setArmoire(Armoire armoire) {
		this.armoire = armoire;
	}

	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte c) {
		this.compte = c;
	}

	public int getWingBuff() {
		return wingBuff;
	}

	public void setWingBuff(int wingBuff) {
		this.wingBuff = wingBuff;
	}
	
	
	// --- To String
	@Override
	public String toString() {
		return "SkyKid [ nom=" + nom + ", " + ", armoire=" + armoire + "]";
	}


	
}
