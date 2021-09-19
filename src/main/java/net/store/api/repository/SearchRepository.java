package net.store.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.store.api.model.Product;

@Repository
public interface SearchRepository extends JpaRepository<Product, Long>{
	 List<Product> findByCategoryIgnoreCase(String catergory);
}



