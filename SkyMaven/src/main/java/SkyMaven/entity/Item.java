package SkyMaven.entity;

public abstract class Item {
	
	// --- Attributs
	
	protected String libelle;
	protected int prix;
	
	// --- Constructeurs
	
	public Item(String libelle, int prix)
	{
		this.libelle = libelle;
		this.prix = prix;
	}
	
	// --- Getters / Setters
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String Libelle) {
		this.libelle = libelle;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}

	// --- To String
	@Override
	public String toString() {
		return "Item [libelle=" + libelle + ", prix=" + prix + "]";
	}
}
