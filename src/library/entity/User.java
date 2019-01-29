package library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {

	@Id
	@NotNull(message="is required")
	@NotEmpty
	@Column(name="login")
	private String login;	
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@NotEmpty
	@Transient
	private String passwordConfirmed;
	
	@Column(name="enabled", columnDefinition="INT NOT NULL DEFAULT 1")
	private int enabled = 1;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Reader reader;
	
	@OneToMany(mappedBy="user",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	private List<Authority> authorities;

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

	public String getPasswordConfirmed() {
		return passwordConfirmed;
	}

	public void setPasswordConfirmed(String passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", passwordConfirmed=" + passwordConfirmed
				+ ", enabled=" + enabled + ", reader=" + reader + ", authorities=" + authorities + "]";
	}

	
	






	
	
	
	
	
}
