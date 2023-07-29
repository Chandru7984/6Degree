package com.degree.subscribe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.degree.subscribe.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT cust FROM Customer cust WHERE cust.isdeleted = 0 AND cust.email = :email ")
	Optional<Customer> findByEmail(@Param("email") String email);
	
	Boolean existsByEmail(String email);

	Boolean existsByMobile(String mobile);
	
	@Query("SELECT cust FROM Customer cust "
			+ " JOIN Designer desi ON (desi.isdeleted =0 and desi.id= cust.designerid)"
			+ " WHERE( cust.designerid = :designerid)")
	List<Customer> getCustomerByDesignerId(@Param("designerid") Long
			designerid);
	
	Customer findByResetpasswordtoken(String resetpasswordtoken);
	

}
