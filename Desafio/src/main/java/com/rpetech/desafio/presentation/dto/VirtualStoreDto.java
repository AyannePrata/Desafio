package com.rpetech.desafio.presentation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class VirtualStoreDto {
	
	private Integer id;
	private String cnpj;
	private String name;
	
	@NotBlank(message = "É obrigatório informar o segmento de atuação da loja!")
	@Pattern(regexp = "^[a-zA-ZÀ-ú\\s]{3,255}$", message = "Segmento inválido! Deve possuir mais que 3 caracteres e não possuir caracteres especiais")
	private String segment;
	
	private String telephone;
	private String urlVirtualStore;
	private String assessment;
	
	public VirtualStoreDto() {
		
	}
	
	public VirtualStoreDto(String cnpj, String name, String segment, String telephone, String urlVirtualStore,
			String assessment) {
		this.cnpj = cnpj;
		this.name = name;
		this.segment = segment;
		this.telephone = telephone;
		this.urlVirtualStore = urlVirtualStore;
		this.assessment = assessment;
	}
	
	public VirtualStoreDto(Integer id, String cnpj, String name, String segment, String telephone, String urlVirtualStore,
			String assessment) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.segment = segment;
		this.telephone = telephone;
		this.urlVirtualStore = urlVirtualStore;
		this.assessment = assessment;
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

	public String getUrlVirtualStore() {
		return urlVirtualStore;
	}

	public void setUrlVirtualStore(String urlVirtualStore) {
		this.urlVirtualStore = urlVirtualStore;
	}


	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}


}
