package SkyMaven.entity;

public class Esprit {

	// --- Attributs

	private String nom;
	
	// --- Constructeurs
	
	public Esprit(String nom)
	{
		this.nom = nom;
	}
	
	// --- Getters / Setters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	// --- To String
	@Override
	public String toString() {
		return "Esprit [nom=" + nom + "]";
	}
}
