package net.store.api.model;

public class ShoppingCartReponse {

	// TODO: don't include whole ShoppingCart. Refactor it later 
	private ShoppingCart lineItem;
	private Product productDetails;
	
	public ShoppingCart getLineItem() {
		return lineItem;
	}
	public void setLineItem(ShoppingCart lineItem) {
		this.lineItem = lineItem;
	}
	public Product getProduct() {
		return productDetails;
	}
	public void s(Product productDetails) {
		this.productDetails = productDetails;
	}
	public ShoppingCartReponse() {
		super();
	}
	public ShoppingCartReponse(ShoppingCart lineItem, Product productDetails) {
		super();
		this.lineItem = lineItem;
		this.productDetails = productDetails;
	}	
}
