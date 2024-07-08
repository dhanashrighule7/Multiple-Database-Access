package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.primary.PrimaryEntity;
import com.example.model.secondary.SecondaryEntity;
import com.example.repository.primary.PrimaryRepository;
import com.example.repository.secondary.SecondaryRepository;

@Service
public class TransactionalService {

	private final PrimaryRepository primaryRepository;
	private final SecondaryRepository secondaryRepository;

	public TransactionalService(PrimaryRepository primaryRepository, SecondaryRepository secondaryRepository) {
		this.primaryRepository = primaryRepository;
		this.secondaryRepository = secondaryRepository;
	}

	@Transactional(value = "chainedTransactionManager")
	public void transferData(Long primaryId, Long secondaryId) {
		PrimaryEntity primaryEntity = primaryRepository.findById(primaryId).orElseThrow();
		SecondaryEntity secondaryEntity = secondaryRepository.findById(secondaryId).orElseThrow();

		// Business logic to transfer data between entities
		primaryEntity.setFirstName(secondaryEntity.getFirstName());
		secondaryEntity.setLastName(primaryEntity.getLastName());

		primaryRepository.save(primaryEntity);
		secondaryRepository.save(secondaryEntity);
	}
}
