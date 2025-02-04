package com.example.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.primary.PrimaryEntity;

@Repository
public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
	PrimaryEntity findById(long id);
}