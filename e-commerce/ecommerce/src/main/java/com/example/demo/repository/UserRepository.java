package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Designer;

public interface UserRepository extends JpaRepository<Designer, Long> {

//	@Query("SELECT dsgn FROM Designer dsgn WHERE dsgn.isdeleted = 0 AND dsgn.email = :email ")
	Optional<Designer> findByEmail(String email);

	Boolean existsByEmail(String email);

	Boolean existsByMobile(String mobile);

	Boolean existsByPassword(String password);

	@Query("SELECT des from Designer des WHERE id = :id")
	Optional<Designer> findById(Long id);
}
