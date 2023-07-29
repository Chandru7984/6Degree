package com.degree.subscribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.degree.subscribe.entity.CustomerAddress;

public interface CustomerAddRepository extends JpaRepository<CustomerAddress, Long>{

}
