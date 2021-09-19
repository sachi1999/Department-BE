package net.store.api.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.hash.Hashing;

import net.store.api.model.LoginRequest;
import net.store.api.model.Product;
import net.store.api.model.UserDetail;
import net.store.api.repository.SearchRepository;
import net.store.api.repository.UserDetailsRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/search")
@RestController
public class SearchController {
	
	@Autowired
	private SearchRepository searchepository;
	
	
	@RequestMapping(value = "/catergory", method = RequestMethod.GET)
	public List<Product> GetProductsByCategory(@RequestParam(value = "catergory") String category)
	{
		List<Product> list  = searchepository.GetProductsByCategory(category);
	    return list;
	}
	
	

	@PostMapping("/AddProduct")
	public List<Product> AddProduct(@RequestBody Product product )
	{
		searchepository.save(product);
		return searchepository.findAll();

	}
	
	

}
