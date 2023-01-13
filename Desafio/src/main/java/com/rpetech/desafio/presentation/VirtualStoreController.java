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


import com.rpetech.desafio.model.VirtualStore;
import com.rpetech.desafio.presentation.dto.VirtualStoreDto;
import com.rpetech.desafio.business.VirtualStoreConverterService;
import com.rpetech.desafio.business.VirtualStoreService;

@RestController
@RequestMapping("/api/virtual")
public class VirtualStoreController {
	
	@Autowired
	private VirtualStoreService virtualStoreService;
	
	@Autowired
	private VirtualStoreConverterService virtualStoreConverterService;
	
	@GetMapping
	public ResponseEntity getAll() {
		List<VirtualStore> entityList = virtualStoreService.findAll();
		
		List<VirtualStoreDto> dtoList = virtualStoreConverterService.virtualsStoresToDtos(entityList);
		
		return ResponseEntity.ok().body(dtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		
		try {
			VirtualStore entity = virtualStoreService.findById(id);
			VirtualStoreDto dto = virtualStoreConverterService.virtualStoreToDto(entity);
			
			return ResponseEntity.ok().body(dto);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody VirtualStoreDto dto) {
		
		try {
			VirtualStore entity = virtualStoreConverterService.dtoToVirtualStore(dto);
			entity = virtualStoreService.save(entity);
			dto = virtualStoreConverterService.virtualStoreToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Integer id, @RequestBody VirtualStoreDto dto) {
		
		try {
			dto.setId(id);
			VirtualStore entity = virtualStoreConverterService.dtoToVirtualStore(dto);
			entity = virtualStoreService.update(entity);
			dto = virtualStoreConverterService.virtualStoreToDto(entity);
			
			return ResponseEntity.ok().body(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		
		try {
			virtualStoreService.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}


}
