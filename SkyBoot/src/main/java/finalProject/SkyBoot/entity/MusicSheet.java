package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="node_ref_id",foreignKey = @ForeignKey(name="MUSICSHEET_NODE_REF_ID_FK"))
	@JsonView(JsonViews.ItemWithNode.class)
	protected NodeRef nodeRef;
	
	public MusicSheet() {
		super();
	}
	
	public MusicSheet(String nom, int prix)
	{
		super(nom,prix);
	}

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

}
