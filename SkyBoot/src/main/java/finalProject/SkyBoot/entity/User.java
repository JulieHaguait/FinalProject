package finalProject.SkyBoot.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="compte") // user réservé !!!
@SequenceGenerator(name="seqUser", sequenceName="seq_user", initialValue=100, allocationSize=1)
@JsonTypeInfo(
		use=JsonTypeInfo.Id.NAME,
		include=JsonTypeInfo.As.PROPERTY,
		property="type"
		)
@JsonSubTypes({
	@Type(value=Admin.class, name="admin"),
	@Type(value=SkyKid.class, name="skykid"),
})

public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUser")
	@JsonView({JsonViews.Common.class, JsonViews.modifLogin.class})
	protected Long id;
	@JsonView({JsonViews.Common.class, JsonViews.modifLogin.class})
	protected String login;
	protected String password;

	public User() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + this.getClass().getSimpleName().toUpperCase()));
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

