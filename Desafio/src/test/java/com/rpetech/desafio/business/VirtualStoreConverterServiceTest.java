package com.rpetech.desafio.business;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rpetech.desafio.model.PhysicalStore;
import com.rpetech.desafio.model.VirtualStore;
import com.rpetech.desafio.presentation.dto.PhysicalStoreDto;
import com.rpetech.desafio.presentation.dto.VirtualStoreDto;
import com.rpetech.desafio.business.VirtualStoreConverterService;

public class VirtualStoreConverterServiceTest {
	
	private static VirtualStoreConverterService converterService;
	private static VirtualStore entity;
	private static VirtualStoreDto dto;
	
	
	@BeforeAll
	public static void setUp() {
		converterService = new VirtualStoreConverterService();
		
		System.out.println("Definindo atributos para entidade...");
		entity = new VirtualStore();
		entity.setId(1);
		entity.setCnpj("00.000.000/0001-00");
		entity.setName("Loja de Doces D. João");
		entity.setSegment("Confeitaria");
		entity.setTelephone("(00) 000000000");
		entity.setUrlVirtualStore("http://aaaa.com");
		entity.setAssessment("Fiz uma ótima compra");
		
		System.out.println("Definindo atributos para dto...");
		dto = new VirtualStoreDto();
		dto.setId(1);
		dto.setCnpj("00.000.000/0001-00");
		dto.setName("Loja de Doces D. João");
		dto.setSegment("Confeitaria");
		dto.setTelephone("(00) 000000000");
		dto.setUrlVirtualStore("http://aaaa.com");
		dto.setAssessment("Fiz uma ótima compra");
		
	}
	
	@Test
	public void testConvertEntityToDto() {
		VirtualStoreDto dtoConverted = converterService.virtualStoreToDto(entity);
		assertAll("Comparando DTO e entidade campo por campo",
			() -> assertEquals(dtoConverted.getId(), entity.getId()),
			() -> assertEquals(dtoConverted.getCnpj(), entity.getCnpj()),
			() -> assertEquals(dtoConverted.getName(), entity.getName()),
			() -> assertEquals(dtoConverted.getSegment(), entity.getSegment()),
			() -> assertEquals(dtoConverted.getTelephone(), entity.getTelephone()),
			() -> assertEquals(dtoConverted.getUrlVirtualStore(), entity.getUrlVirtualStore()),
			() -> assertEquals(dtoConverted.getAssessment(), entity.getAssessment())
		);
	}
	
	@Test
	public void testConvertDtoToEntity() {
		VirtualStore entityConverted = converterService.dtoToVirtualStore(dto);
		assertAll("Comparando entidade e DTO campo por campo",
			() -> assertEquals(entityConverted.getId(), dto.getId()),
			() -> assertEquals(entityConverted.getCnpj(), dto.getCnpj()),
			() -> assertEquals(entityConverted.getName(), dto.getName()),
			() -> assertEquals(entityConverted.getSegment(), entity.getSegment()),
			() -> assertEquals(entityConverted.getTelephone(), entity.getTelephone()),
			() -> assertEquals(entityConverted.getUrlVirtualStore(), entity.getUrlVirtualStore()),
			() -> assertEquals(entityConverted.getAssessment(), entity.getAssessment())
		);
	}
	
	@Test
	public void testConvertEntityToDtoThrowsNullPointerException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> converterService.virtualStoreToDto(null));
		assertEquals("Não foi possível converter pois o objeto é nulo", exception.getMessage());
	}
	
	@Test
	public void testConvertDtoToEntityThrowsNullPointerException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> converterService.dtoToVirtualStore(null));
		assertEquals("Não foi possível converter pois o objeto é nulo", exception.getMessage());
	}


}
