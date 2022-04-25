package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "music_sheet")
@DiscriminatorValue("MS")
public class MusicSheet extends Item{

	
	public MusicSheet() {
		
	}
	
	public MusicSheet(String nom, int prix)
	{
		super(nom,prix);
	}


	public void jouerMusicSheet()
	{
	}

}
