package net.store.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.store.api.model.Product;
import net.store.api.model.ShoppingCart;
import net.store.api.model.ShoppingCartReponse;
import net.store.api.model.UserDetail;
import net.store.api.repository.CartRepository;
import net.store.api.repository.SearchRepository;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", originPatterns = "true")
@RequestMapping("/api/v1/cart")
@RestController
public class ShoppingCartController {

	@Autowired
	private CartRepository cartrepository;

	@Autowired
	private SearchRepository searchepository;

	@RequestMapping(value = "/GetShoppingCart", method = RequestMethod.GET)
	public List<ShoppingCartReponse> GetShoppingCart(@RequestParam(value = "emailId") String emailId) {

		List<Long> ids = new ArrayList<Long>();
		List<ShoppingCart> list = cartrepository.findByEmailIdIgnoreCase(emailId);
		// Better solution would be joining the tables
		// TODO: Change this to joining product and cart tables
		for (int i = 0; i < list.size(); i++) {
			ShoppingCart s = list.get(i);
			ids.add(s.getProductId());
		}

		List<Product> prod = searchepository.findAllById(ids);
		Map<Long, Product> map = new HashMap<>();
		prod.forEach(i -> map.put(i.getId(), i));
		List<ShoppingCartReponse> cart = new ArrayList<ShoppingCartReponse>();

		for (int i = 0; i < list.size(); i++) {
			ShoppingCart s = list.get(i);
			ShoppingCartReponse cartItem = new ShoppingCartReponse(s, map.get(s.getProductId()));
			cart.add(cartItem);
		}

		cart.removeIf(c ->  c.getLineItem().getQuantity() <= 0);
		return cart;
	}

	@RequestMapping(value = "/UpdateShoppingCart", method = RequestMethod.POST)
	public List<ShoppingCartReponse> addOrUpdateShoppingCart(@RequestBody ShoppingCart cart) {

		List<ShoppingCart> list = cartrepository.findByEmailIdIgnoreCase(cart.getEmailId());
		if (list.size() > 0) {
			ShoppingCart toUpdatCart = null;
			for (int i = 0; i < list.size(); i++) {
				ShoppingCart s = list.get(i);
				if (cart.getProductId().equals(s.getProductId())) {
					toUpdatCart = new ShoppingCart();
					toUpdatCart = cart;
					toUpdatCart.setId(s.getId());
				}
			}
			if (toUpdatCart != null) {
				int qty = cart.getQuantity();
				
				if (qty > 0) {
					toUpdatCart.setQuantity(qty);
					cartrepository.save(toUpdatCart);
				} else {
					cartrepository.deleteById(toUpdatCart.getId());
				}
				return this.GetShoppingCart(cart.getEmailId());
			}
		} 
		
		cartrepository.save(cart);
		return this.GetShoppingCart(cart.getEmailId());
	}

}
