package net.store.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.store.api.model.UserDetail;

@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDetail, Long>  {	  
	    UserDetail findByEmailIdIgnoreCase(String emailId);
}
