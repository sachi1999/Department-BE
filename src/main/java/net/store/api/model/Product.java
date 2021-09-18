package net.store.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	private Long productId;
	private String category;
	private String productType;
	private int price;
	private String currency;
	private int quantity;
	private String description;
	private String imageUrl;

	public Product() {
		super();
	}

	public Product(String category, String product, int price, String currency, int quantity, String description,String imageUrl) {
		super();
		this.category = category;
		this.productType = product;
		this.price = price;
		this.currency = currency;
		this.quantity = quantity;
		this.description = description;
	}

	@Id       
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") 
	public Long getId() {
		return productId;
	}

	public void setId(Long id) {
		this.productId = id;
	}

	@Column(name = "category", nullable = false)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "Product_name", nullable = false)
	public String getProductType() {
		return productType;
	}

	public void setProductType(String product) {
		this.productType = product;
	}

	@Column(name = "Product_price", nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "Currency", nullable = false)
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "product_quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "product_description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "product_image", nullable = false)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
