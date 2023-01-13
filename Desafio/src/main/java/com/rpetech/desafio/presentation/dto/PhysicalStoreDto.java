package com.rpetech.desafio.presentation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PhysicalStoreDto {
	
	private Integer id;
	private String cnpj;
	private String name;
	
	@NotBlank(message = "É obrigatório informar o segmento de atuação da loja!")
	@Pattern(regexp = "^[a-zA-ZÀ-ú\\s]{3,255}$", message = "Segmento inválido! Deve possuir mais que 3 caracteres e não possuir caracteres especiais")
	private String segment;
	
	private String telephone;
	private String address;
	private Integer numberEmployees;
	
	
	public PhysicalStoreDto() {
		
	}
	
	public PhysicalStoreDto(String cnpj, String name, String segment, String telephone, String address,
			Integer numberEmployees) {
		this.cnpj = cnpj;
		this.name = name;
		this.segment = segment;
		this.telephone = telephone;
		this.address = address;
		this.numberEmployees = numberEmployees;
	}

	public PhysicalStoreDto(Integer id, String cnpj, String name, String segment, String telephone, String address,
			Integer numberEmployees) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.segment = segment;
		this.telephone = telephone;
		this.address = address;
		this.numberEmployees = numberEmployees;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}


}
