package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "music_sheet")
@DiscriminatorValue("MS")
public class MusicSheet extends Item{
	@ManyToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="MUSICSHEET_NODE_ID_FK"))
	protected Node node;
	
	public MusicSheet() {
		super();
	}
	
	public MusicSheet(String nom, int prix)
	{
		super(nom,prix);
	}


	public void jouerMusicSheet()
	{
	}

}
