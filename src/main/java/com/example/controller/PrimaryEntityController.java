package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.primary.PrimaryEntity;
import com.example.service.PrimaryEntityService;

@RestController
@RequestMapping("/api/primary")
public class PrimaryEntityController {

	private final PrimaryEntityService primaryEntityService;

	@Autowired
	public PrimaryEntityController(PrimaryEntityService primaryEntityService) {
		this.primaryEntityService = primaryEntityService;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveDataPrimaryEntity(@RequestBody PrimaryEntity primaryEntity) {
		primaryEntityService.save(primaryEntity); // Assuming service method for saving
		return ResponseEntity.status(HttpStatus.CREATED).body("Primary entity saved successfully");
	}

	@PostMapping("/primary-entity/save")
	public ResponseEntity<String> savePrimaryEntity(@RequestBody PrimaryEntity primaryEntity) {
		primaryEntityService.saveAndTransferData(primaryEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("Primary entity saved and data transferred successfully");
	}

	@PostMapping("/primary-entity/transfer")
	public ResponseEntity<String> transferData() {
		primaryEntityService.transferData();
		return ResponseEntity.ok("Data transferred successfully");
	}
}
