package library.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH},  fetch=FetchType.EAGER)
	@JoinColumn(name="id_category")
	private Category category;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_author")	
	private Author author;
	
		
	@Column(name="quantity")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=100, message="must be less than or equal to 100")
	private int quantity;
	
	@Column(name="title")
	@NotNull(message="is required")
	@Size(min=1)
	private String title;
	
	@Column(name="publishing_house")
	@NotNull(message="is required")
	@Size(min=1)
	private String publishingHouse;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_publish")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate datepublish;
	
	@OneToMany(mappedBy="book",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})	
	private List<OrderItem> orderItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		System.out.println("Sprawdzian get");
		return title;
	}

	public void setTitle(String title) {
		System.out.println("Sprawdzian set");
		this.title = title;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDatepublish() {
		return datepublish;
	}

	public void setDatepublish(LocalDate datepublish) {
		this.datepublish = datepublish;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category.getName() + ", author=" + author.getFullName() + ", quantity=" + quantity
				+ ", title=" + title + ", publishingHouse=" + publishingHouse + ", description=" + description
				+ ", datepublish=" + datepublish +  "]";
	}
	
	

	
}
