package finalProject.SkyBoot.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cosmetique")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 2)
public class Cosmetic extends Item{
	
	@OneToOne
	@JoinColumn(name="node_ref_id",foreignKey = @ForeignKey(name="COSMETIC_NODE_REF_ID_FK"))
	protected NodeRef nodeRef;
	
	public Cosmetic(){
		super();
	}
	
	public Cosmetic(String libelle, int prix)
	{
		super(libelle,prix);
	}

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

	
	
}