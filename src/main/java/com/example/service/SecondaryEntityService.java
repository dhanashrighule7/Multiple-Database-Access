package com.example.service;

import com.example.model.secondary.SecondaryEntity;
import com.example.repository.secondary.SecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondaryEntityService {

	private final SecondaryRepository secondaryRepository;

	@Autowired
	public SecondaryEntityService(SecondaryRepository secondaryRepository) {
		this.secondaryRepository = secondaryRepository;
	}

	public List<SecondaryEntity> getAllSecondaryEntities() {
		return secondaryRepository.findAll();
	}

	public SecondaryEntity getSecondaryEntityById(Long id) {
		return secondaryRepository.findById(id).orElse(null);
	}
}
