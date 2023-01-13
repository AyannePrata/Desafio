package com.rpetech.desafio.presentation.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.rpetech.desafio.presentation.dto.VirtualStoreDto;

public class VirtualStoreDtoTest {
	
	private VirtualStoreDto dto;
	private Set<ConstraintViolation<VirtualStoreDto>> violations;
	private static Validator validator;
	
	@BeforeAll
	public static void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@BeforeEach
	public void beforeEach() {
		dto = new VirtualStoreDto();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Cosméticos", " Confecções", "alimentação   "}) // VÁLIDO
	public void segmentIsValid(String s) {
		dto.setSegment(s);
		violations = validator.validateProperty(dto, "segment");
		
		if(violations.size() != 0) {
			System.out.println(s + " => " + violations.stream().findFirst().get().getMessage());	
		}
		assertEquals(0, violations.size(), "SEGMENTO iNVÁLIDO DETECTADO<" + s + ">");
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "Al", "", "   ", "p/", "p/p/", " Aliment@ção  ", " *", "   &Ta ", ","}) // iNVÁLIDO
	public void segmentIsInvalid(String s) {
		dto.setSegment(s);
		violations = validator.validateProperty(dto, "segment");
		
		assertNotEquals(0, violations.size(), "SEGMENTO VÁLIDO DETECTADO< " + s + " >");
	}

}
