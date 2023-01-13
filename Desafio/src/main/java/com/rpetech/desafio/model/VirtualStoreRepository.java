package com.rpetech.desafio.model;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rpetech.desafio.model.VirtualStore;

@Repository
public interface VirtualStoreRepository extends JpaRepository <VirtualStore, Integer> {
	
	public Optional<VirtualStore> findByName(String name);
	public boolean existsByCnpj(String cnpj);

}
