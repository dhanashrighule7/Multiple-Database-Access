//package com.example.service;
//
//import com.example.model.primary.PrimaryEntity;
//import com.example.repository.primary.PrimaryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PrimaryEntityService {
//
//	private final PrimaryRepository primaryRepository;
//
//	@Autowired
//	public PrimaryEntityService(PrimaryRepository primaryRepository) {
//		this.primaryRepository = primaryRepository;
//	}
//
//	public void save(PrimaryEntity primaryEntity) {
//		primaryRepository.save(primaryEntity);
//	}
//}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.primary.PrimaryEntity;
import com.example.model.secondary.SecondaryEntity;
import com.example.repository.primary.PrimaryRepository;
import com.example.repository.secondary.SecondaryRepository;

@Service
public class PrimaryEntityService {

	private final PrimaryRepository primaryRepository;
	private final SecondaryRepository secondaryRepository;

	@Autowired
	public PrimaryEntityService(PrimaryRepository primaryRepository, SecondaryRepository secondaryRepository) {
		this.primaryRepository = primaryRepository;
		this.secondaryRepository = secondaryRepository;
	}

	public void save(PrimaryEntity primaryEntity) {
		primaryRepository.save(primaryEntity);
	}

	public void saveAndTransferData(PrimaryEntity primaryEntity) {
		// Save into PrimaryEntity table
		primaryRepository.save(primaryEntity);

		// Transfer data to SecondaryEntity
		SecondaryEntity secondaryEntity = new SecondaryEntity();
		secondaryEntity.setFirstName(primaryEntity.getFirstName());
		secondaryEntity.setLastName(primaryEntity.getLastName());
		secondaryEntity.setUserName(primaryEntity.getUserName());

		secondaryRepository.save(secondaryEntity);
	}

	@Transactional("primaryTransactionManager")
	public List<PrimaryEntity> fetchPrimaryEntities() {
		return primaryRepository.findAll();
	}

	@Transactional("secondaryTransactionManager")
	public void transferData() {
		List<PrimaryEntity> primaryEntities = fetchPrimaryEntities();

		for (PrimaryEntity primaryEntity : primaryEntities) {
			SecondaryEntity secondaryEntity = new SecondaryEntity();
			secondaryEntity.setFirstName(primaryEntity.getFirstName());
			secondaryEntity.setLastName(primaryEntity.getLastName());
			secondaryEntity.setUserName(primaryEntity.getUserName());

			secondaryRepository.save(secondaryEntity);
		}
	}

//	@Transactional
//	public void transferData() {
//		// Fetch all PrimaryEntity records
//		List<PrimaryEntity> primaryEntities = primaryRepository.findAll();
//
//		// Transfer data to SecondaryEntity
//		for (PrimaryEntity primaryEntity : primaryEntities) {
//			SecondaryEntity secondaryEntity = new SecondaryEntity();
//			secondaryEntity.setFirstName(primaryEntity.getFirstName());
//			secondaryEntity.setLastName(primaryEntity.getLastName());
//			secondaryEntity.setUserName(primaryEntity.getUserName());
//
//			// Save into SecondaryEntity table
//			secondaryRepository.save(secondaryEntity);
//		}
//	}
}
