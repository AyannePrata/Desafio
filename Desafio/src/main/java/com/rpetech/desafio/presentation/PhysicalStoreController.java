package com.rpetech.desafio.presentation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpetech.desafio.model.PhysicalStore;
import com.rpetech.desafio.presentation.dto.PhysicalStoreDto;
import com.rpetech.desafio.business.PhysicalStoreConverterService;
import com.rpetech.desafio.business.PhysicalStoreService;

@RestController
@RequestMapping("/api/physical")
public class PhysicalStoreController {
	
	@Autowired
	private PhysicalStoreService physicalStoreService;
	
	@Autowired
	private PhysicalStoreConverterService physicalStoreConverterService;
	
	@GetMapping
	public ResponseEntity getAll() {
		List<PhysicalStore> entityList = physicalStoreService.findAll();
		
		List<PhysicalStoreDto> dtoList = physicalStoreConverterService.physicalsStoresToDtos(entityList);
		
		return ResponseEntity.ok().body(dtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		
		try {
			PhysicalStore entity = physicalStoreService.findById(id);
			PhysicalStoreDto dto = physicalStoreConverterService.physicalStoreToDto(entity);
			
			return ResponseEntity.ok().body(dto);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody PhysicalStoreDto dto) {
		
		try {
			PhysicalStore entity = physicalStoreConverterService.dtoToPhysicalStore(dto);
			entity = physicalStoreService.save(entity);
			dto = physicalStoreConverterService.physicalStoreToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Integer id, @RequestBody PhysicalStoreDto dto) {
		
		try {
			dto.setId(id);
			PhysicalStore entity = physicalStoreConverterService.dtoToPhysicalStore(dto);
			entity = physicalStoreService.update(entity);
			dto = physicalStoreConverterService.physicalStoreToDto(entity);
			
			return ResponseEntity.ok().body(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		
		try {
			physicalStoreService.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
