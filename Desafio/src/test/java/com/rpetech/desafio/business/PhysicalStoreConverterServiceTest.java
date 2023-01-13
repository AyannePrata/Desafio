package com.rpetech.desafio.business;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rpetech.desafio.model.PhysicalStore;
import com.rpetech.desafio.presentation.dto.PhysicalStoreDto;
import com.rpetech.desafio.business.PhysicalStoreConverterService;

public class PhysicalStoreConverterServiceTest {
	
	private static PhysicalStoreConverterService converterService;
	private static PhysicalStore entity;
	private static PhysicalStoreDto dto;
	
	
	@BeforeAll
	public static void setUp() {
		converterService = new PhysicalStoreConverterService();
		
		System.out.println("Definindo atributos para entidade...");
		entity = new PhysicalStore();
		entity.setId(1);
		entity.setCnpj("00.000.000/0001-00");
		entity.setName("Loja de Doces D. João");
		entity.setSegment("Confeitaria");
		entity.setTelephone("(00) 000000000");
		entity.setAddress("Rua dos Limões, 00");
		entity.setNumberEmployees(12);
		
		System.out.println("Definindo atributos para dto...");
		dto = new PhysicalStoreDto();
		dto.setId(1);
		dto.setCnpj("00.000.000/0001-00");
		dto.setName("Loja de Doces D. João");
		dto.setSegment("Confeitaria");
		dto.setTelephone("(00) 000000000");
		dto.setAddress("Rua dos Limões, 00");
		dto.setNumberEmployees(12);
		
	}
	
	@Test
	public void testConvertEntityToDto() {
		PhysicalStoreDto dtoConverted = converterService.physicalStoreToDto(entity);
		assertAll("Comparando DTO e entidade campo por campo",
			() -> assertEquals(dtoConverted.getId(), entity.getId()),
			() -> assertEquals(dtoConverted.getCnpj(), entity.getCnpj()),
			() -> assertEquals(dtoConverted.getName(), entity.getName()),
			() -> assertEquals(dtoConverted.getSegment(), entity.getSegment()),
			() -> assertEquals(dtoConverted.getTelephone(), entity.getTelephone()),
			() -> assertEquals(dtoConverted.getAddress(), entity.getAddress()),
			() -> assertEquals(dtoConverted.getNumberEmployees(), entity.getNumberEmployees())
		);
	}
	
	@Test
	public void testConvertDtoToEntity() {
		PhysicalStore entityConverted = converterService.dtoToPhysicalStore(dto);
		assertAll("Comparando entidade e DTO campo por campo",
			() -> assertEquals(entityConverted.getId(), dto.getId()),
			() -> assertEquals(entityConverted.getCnpj(), dto.getCnpj()),
			() -> assertEquals(entityConverted.getName(), dto.getName()),
			() -> assertEquals(entityConverted.getSegment(), entity.getSegment()),
			() -> assertEquals(entityConverted.getTelephone(), entity.getTelephone()),
			() -> assertEquals(entityConverted.getAddress(), entity.getAddress()),
			() -> assertEquals(entityConverted.getNumberEmployees(), entity.getNumberEmployees())
		);
	}
	
	@Test
	public void testConvertEntityToDtoThrowsNullPointerException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> converterService.physicalStoreToDto(null));
		assertEquals("Não foi possível converter pois o objeto é nulo", exception.getMessage());
	}
	
	@Test
	public void testConvertDtoToEntityThrowsNullPointerException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> converterService.dtoToPhysicalStore(null));
		assertEquals("Não foi possível converter pois o objeto é nulo", exception.getMessage());
	}

}
