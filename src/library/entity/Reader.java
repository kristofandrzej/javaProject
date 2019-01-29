package library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reader")
public class Reader {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;	
	
	@Column(name="login", nullable=false)
	@NotNull(message="is required")
	@Size(min=1)
	private String login;
	
	@Column(name="first_name")
	@NotNull(message="is required")
	@Size(min=1)
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="is required")
	@Size(min=1)
	private String lastName;
	
	@Column(name="address")
	@NotNull(message="is required")
	@Size(min=1)
	private String address;
	
	@Column(name="city")
	@NotNull(message="is required")
	@Size(min=1)
	private String city;
	
	@Column(name="zip_code")
	@NotNull(message="is required")
	@Size(min=1)
	private String zipCode;
	
	@Column(name="email")
	@NotNull(message="is required")
	@Email
	@Size(min=1)
	private String email;
	
	@Column(name="phone_number")
	@NotNull(message="is required")
	@Size(min=1)
	private String phoneNumber;
	
	@OneToMany(mappedBy="reader",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})	
	private List<Order> orders;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="login", insertable=false, updatable=false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", orders=" + orders + ", user=" + user + "]";
	}


	


	
	
	
}
