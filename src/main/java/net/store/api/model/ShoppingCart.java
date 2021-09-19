package net.store.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

	private long id;
	private Long productId;
	private int quantity;
	private String emailId;
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Long productId, int quantity, String emailId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.emailId = emailId;
	}
	
	@Id       
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "productId", nullable = false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "product_quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "emailId", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	


	
}
