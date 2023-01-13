package com.rpetech.desafio.model;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rpetech.desafio.model.PhysicalStore;

@Repository
public interface PhysicalStoreRepository extends JpaRepository <PhysicalStore, Integer> {
	
	public Optional<PhysicalStore> findByName(String name);
	public boolean existsByCnpj(String cnpj);

}
