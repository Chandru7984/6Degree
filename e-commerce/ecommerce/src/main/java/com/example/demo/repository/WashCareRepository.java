package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WashCare;

public interface WashCareRepository extends JpaRepository<WashCare, Long>{

}
