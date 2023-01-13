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

@Table(name = "PHYSICAL_STORE", uniqueConstraints = {@UniqueConstraint(columnNames = {"PHYSICAL_STORE_CNPJ"})})
@Entity
public class PhysicalStore implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHYSICAL_STORE_ID")
	private Integer id;
	
	@Column(name = "PHYSICAL_STORE_CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name = "PHYSICAL_STORE_NAME", nullable = false)
	private String name;
	
	@Column(name = "PHYSICAL_STORE_SEGMENT", nullable = false)
	private String segment;
	
	@Column(name = "PHYSICAL_STORE_TELEPHONE", nullable = false)
	private String telephone;
	
	@Column(name = "PHYSICAL_STORE_ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "PHYSICAL_STORE_NUMBER_EMPLOYEES", nullable = false)
	private Integer numberEmployees;
	
	
	public PhysicalStore() {
		
	}

	public PhysicalStore(Integer id, String cnpj, String name, String segment, String telephone, String address,
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
		PhysicalStore other = (PhysicalStore) obj;
		return Objects.equals(id, other.id);
	}
	


}
