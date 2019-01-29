package library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="librarian")
public class Librarian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")	
	private int id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="pass")
	private String pass;
	
	
	
}
