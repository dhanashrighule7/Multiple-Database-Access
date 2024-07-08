package com.example.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.primary.PrimaryEntity;
import com.example.model.secondary.SecondaryEntity;

@Repository
public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {
	SecondaryEntity findById(long id);

}