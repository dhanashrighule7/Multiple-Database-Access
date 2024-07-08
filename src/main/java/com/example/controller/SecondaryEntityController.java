package com.example.controller;

import com.example.model.secondary.SecondaryEntity;
import com.example.service.SecondaryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secondary-entity")
public class SecondaryEntityController {

	private final SecondaryEntityService secondaryEntityService;

	@Autowired
	public SecondaryEntityController(SecondaryEntityService secondaryEntityService) {
		this.secondaryEntityService = secondaryEntityService;
	}

	@GetMapping("/all")
	public List<SecondaryEntity> getAllSecondaryEntities() {
		return secondaryEntityService.getAllSecondaryEntities();
	}

	@GetMapping("/{id}")
	public SecondaryEntity getSecondaryEntityById(@PathVariable Long id) {
		return secondaryEntityService.getSecondaryEntityById(id);
	}
}
