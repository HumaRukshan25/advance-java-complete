package Demoo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity

public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double amount;
	@CreationTimestamp
	private LocalDateTime orderedDateTime;
	@UpdateTimestamp
	private LocalDateTime deliveredDateTime;
	
	@OneToMany
	private List <Product> products;
	
	
	public Orders() {
		
	}
	public Orders(int id, double amount, LocalDateTime orderedDateTime, LocalDateTime deliveredDateTime,
			List<Product> products) {
		super();
		this.id = id;
		this.amount = amount;
		this.orderedDateTime = orderedDateTime;
		this.deliveredDateTime = deliveredDateTime;
		this.products = products;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getOrderedDateTime() {
		return orderedDateTime;
	}
	public void setOrderedDateTime(LocalDateTime orderedDateTime) {
		this.orderedDateTime = orderedDateTime;
	}
	public LocalDateTime getDeliveredDateTime() {
		return deliveredDateTime;
	}
	public void setDeliveredDateTime(LocalDateTime deliveredDateTime) {
		this.deliveredDateTime = deliveredDateTime;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
