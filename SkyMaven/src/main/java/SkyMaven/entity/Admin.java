package SkyMaven.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqUser", sequenceName="seq_user", initialValue=100, allocationSize=1)
public class Admin extends User {

	public Admin() {
		super();
	}

	
	// gerer la BDD

	
}
