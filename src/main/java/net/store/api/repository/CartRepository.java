package net.store.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.api.model.ShoppingCart;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Long>
{
	 List<ShoppingCart> findByEmailIdIgnoreCase(String emailId);
	 
	ShoppingCart findByProductId(long id);
}
