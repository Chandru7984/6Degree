package com.degree.subscribe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.degree.subscribe.entity.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
	
	Optional<Subscriber> findByEmail(String email);
	
	Boolean existsByEmail(String email);
	
//	Boolean existsByMobile(String mobile);

}
