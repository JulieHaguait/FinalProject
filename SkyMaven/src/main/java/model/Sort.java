package model;

public class Sort extends Item{

	private String descriptionAction;
	
	public Sort(String libelle, int prix, String descriptionAction)
	{
		super(libelle, prix);
		this.descriptionAction = descriptionAction;
	}
	
	public Sort randomSort()
	{
		// TODO récup un sort random dans la table des sorts disponibles !
		Sort sort = new Sort(libelle, prix, descriptionAction);
		return sort;
	}
	
	
	
	
	
	
	
}
