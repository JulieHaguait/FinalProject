package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


@Entity
@Table(name = "heart_buying")
public class HeartBuying extends Item{
	
	
	@ManyToOne
	@JoinColumn(name = "node_id", foreignKey = @ForeignKey(name = "HEARTBUYING_NODE_ID_FK"))
	private Node node;


	//Constructor
	
	public HeartBuying() {
		super();
	}
	public HeartBuying(String libelle, int prix) {
		super(libelle, prix);
	}	

	//Method

}
