package com.rpetech.desafio.model;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "VIRTUAL_STORE", uniqueConstraints = {@UniqueConstraint(columnNames = {"VIRTUAL_STORE_CNPJ"})})
@Entity
public class VirtualStore implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHYSICAL_STORE_ID")
	private Integer id;

	@Column(name = "VIRTUAL_STORE_CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name = "VIRTUAL_STORE_NAME", nullable = false)
	private String name;
	
	@Column(name = "VIRTUAL_STORE_SEGMENT", nullable = false)
	private String segment;
	
	@Column(name = "VIRTUAL_STORE_TELEPHONE", nullable = false)
	private String telephone;

	@Column(name = "VIRTUAL_STORE_URL", nullable = false)
	private String urlVirtualStore;
	
	@Column(name = "VIRTUAL_STORE_ASSESSMENT")
	private String assessment;
	
	public VirtualStore() {
		
	}
	
	public VirtualStore(Integer id, String cnpj, String name, String segment, String telephone, String urlVirtualStore,
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualStore other = (VirtualStore) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	


}
