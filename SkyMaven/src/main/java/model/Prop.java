package model;

public class Prop extends Item{

	private String descriptionAction;
	
	public Prop(String nom, int prix, String descriptionAction)
	{
		super(nom,prix);
		this.descriptionAction = descriptionAction;
	}
}
