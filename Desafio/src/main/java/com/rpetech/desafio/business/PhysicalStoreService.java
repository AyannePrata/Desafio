package com.rpetech.desafio.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpetech.desafio.model.PhysicalStoreRepository;
import com.rpetech.desafio.model.PhysicalStore;

import com.rpetech.desafio.presentation.exception.MissingFieldException;
import com.rpetech.desafio.presentation.exception.ObjectAlreadyExistsException;
import com.rpetech.desafio.presentation.exception.ObjectNotFoundException;

@Service
public class PhysicalStoreService {
	
	@Autowired
	private PhysicalStoreRepository physicalStoreRepository;
	
	public List<PhysicalStore> findAll() {
		return physicalStoreRepository.findAll();
	}
	
	public boolean existsById(Integer id) {
		return physicalStoreRepository.existsById(id);
	}

	public boolean existsByCnpj(String cnpj) {
		return physicalStoreRepository.existsByCnpj(cnpj);
	}
	
	public PhysicalStore findById(Integer id) throws Exception {
		if (!existsById(id)) {
			throw new ObjectNotFoundException("Loja Física", "id", id);
		}
		return physicalStoreRepository.getById(id);
	}
	
	public Optional<PhysicalStore> findByCnpj(String cnpj) throws Exception {
		if (cnpj == null || cnpj.isBlank()) {
			throw new MissingFieldException("cnpj");
		}
		
		if (!existsByCnpj(cnpj)) {
			throw new ObjectNotFoundException("Loja Física", "cnpj", cnpj);
		}
		return physicalStoreRepository.findByName(cnpj);
	}
	
	public PhysicalStore save(PhysicalStore physicalStore) throws Exception {
		if (physicalStore.getCnpj() == null || physicalStore.getCnpj().isBlank()) {
			throw new MissingFieldException("cnpj", "save");
		}
		
		if (existsByCnpj(physicalStore.getCnpj())) {
			throw new ObjectAlreadyExistsException("Já existe uma loja física com esse cnpj: " + physicalStore.getCnpj());
		}
		
		return physicalStoreRepository.save(physicalStore);
	}
	
	public PhysicalStore update(PhysicalStore physicalStore) throws Exception {
		if (physicalStore.getCnpj() == null || physicalStore.getCnpj().isBlank()) {
			throw new MissingFieldException("cnpj", "update");
		}
		
		if (physicalStore.getId() == null) {
			throw new MissingFieldException("id", "update");
		} else if (!existsById(physicalStore.getId())) {
			throw new ObjectNotFoundException("Loja Física", "id", physicalStore.getId());
		}
		
		if (existsByCnpj(physicalStore.getCnpj())) {
			PhysicalStore physicalStoreSaved = findByCnpj(physicalStore.getCnpj()).get();
			if (physicalStoreSaved.getId() != physicalStore.getId()) {
				throw new ObjectAlreadyExistsException("Já existe uma loja física com esse cnpj: " + physicalStore.getName());
			}
		}
		
		return physicalStoreRepository.save(physicalStore);
	}
	
	public void delete(PhysicalStore physicalStore) throws Exception {
		if (physicalStore.getId() == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(physicalStore.getId())) {
			throw new ObjectNotFoundException("Loja Física", "id", physicalStore.getId());
		}
		
		physicalStoreRepository.delete(physicalStore);
	}
	
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(id)) {
			throw new ObjectNotFoundException("Loja Física", "id", id);
		}
		
		physicalStoreRepository.deleteById(id);
	}
	
	

}
