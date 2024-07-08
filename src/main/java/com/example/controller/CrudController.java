package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TransactionalService;

@RestController
@RequestMapping("/api")
public class CrudController {

	private final TransactionalService transactionalService;

	public CrudController(TransactionalService transactionalService) {
		this.transactionalService = transactionalService;
	}

	@PostMapping("/transfer")
	public void transferData(@RequestParam Long primaryId, @RequestParam Long secondaryId) {
		transactionalService.transferData(primaryId, secondaryId);
	}
}