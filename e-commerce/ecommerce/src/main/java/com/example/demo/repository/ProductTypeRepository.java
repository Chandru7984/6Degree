package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{

}
