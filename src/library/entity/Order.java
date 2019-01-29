package library.entity;

import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH},  fetch=FetchType.EAGER)
	@JoinColumn(name="id_reader")	
	private Reader reader;
	
	@Column(name="date_order")
	private LocalDate dateOrder;
	
	@Column(name="date_receipt")
	private LocalDate dateReceipt;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(mappedBy="order",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH},  fetch=FetchType.EAGER)	
	private List<OrderItem> orderItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public LocalDate getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}

	public LocalDate getDateReceipt() {
		return dateReceipt;
	}

	public void setDateReceipt(LocalDate dateReceipt) {
		this.dateReceipt = dateReceipt;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", reader=" + reader + ", dateOrder=" + dateOrder + ", dateReceipt=" + dateReceipt
				+ ", status=" + status + ", orderItems=" + orderItems + "]";
	}


	
}
