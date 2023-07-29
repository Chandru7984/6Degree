package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long>{

}
