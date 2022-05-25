package SkyMaven.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "music_sheet")
@DiscriminatorValue("MS")
@SequenceGenerator(name="seqItem", sequenceName="seq_item", initialValue=100, allocationSize=1)
public class MusicSheet extends Item{
	
	@OneToOne
	@JoinColumn(name="node_id",foreignKey = @ForeignKey(name="MUSICSHEET_NODE_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
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

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

}
