package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerAddress;

public interface CustomerAddRepository extends JpaRepository<CustomerAddress, Long>{

}
