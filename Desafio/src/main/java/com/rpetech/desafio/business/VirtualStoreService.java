package com.rpetech.desafio.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpetech.desafio.model.VirtualStoreRepository;
import com.rpetech.desafio.model.VirtualStore;

import com.rpetech.desafio.presentation.exception.MissingFieldException;
import com.rpetech.desafio.presentation.exception.ObjectAlreadyExistsException;
import com.rpetech.desafio.presentation.exception.ObjectNotFoundException;

@Service
public class VirtualStoreService {
	
	@Autowired
	private VirtualStoreRepository virtualStoreRepository;
	
	public List<VirtualStore> findAll() {
		return virtualStoreRepository.findAll();
	}
	
	public boolean existsById(Integer id) {
		return virtualStoreRepository.existsById(id);
	}

	public boolean existsByCnpj(String cnpj) {
		return virtualStoreRepository.existsByCnpj(cnpj);
	}
	
	public VirtualStore findById(Integer id) throws Exception {
		if (!existsById(id)) {
			throw new ObjectNotFoundException("Loja Virtual", "id", id);
		}
		return virtualStoreRepository.getById(id);
	}
	
	public Optional<VirtualStore> findByCnpj(String cnpj) throws Exception {
		if (cnpj == null || cnpj.isBlank()) {
			throw new MissingFieldException("cnpj");
		}
		
		if (!existsByCnpj(cnpj)) {
			throw new ObjectNotFoundException("Loja Virtual", "cnpj", cnpj);
		}
		return virtualStoreRepository.findByName(cnpj);
	}
	
	public VirtualStore save(VirtualStore virtualStore) throws Exception {
		if (virtualStore.getCnpj() == null || virtualStore.getCnpj().isBlank()) {
			throw new MissingFieldException("cnpj", "save");
		}
		
		if (existsByCnpj(virtualStore.getCnpj())) {
			throw new ObjectAlreadyExistsException("Já existe uma loja virtual com esse cnpj: " + virtualStore.getCnpj());
		}
		
		return virtualStoreRepository.save(virtualStore);
	}
	
	public VirtualStore update(VirtualStore virtualStore) throws Exception {
		if (virtualStore.getCnpj() == null || virtualStore.getCnpj().isBlank()) {
			throw new MissingFieldException("cnpj", "update");
		}
		
		if (virtualStore.getId() == null) {
			throw new MissingFieldException("id", "update");
		} else if (!existsById(virtualStore.getId())) {
			throw new ObjectNotFoundException("Loja Virtual", "id", virtualStore.getId());
		}
		
		if (existsByCnpj(virtualStore.getCnpj())) {
			VirtualStore virtualStoreSaved = findByCnpj(virtualStore.getCnpj()).get();
			if (virtualStoreSaved.getId() != virtualStore.getId()) {
				throw new ObjectAlreadyExistsException("Já existe uma loja virtual com esse cnpj: " + virtualStore.getCnpj());
			}
		}
		
		return virtualStoreRepository.save(virtualStore);
	}
	
	public void delete(VirtualStore virtualStore) throws Exception {
		if (virtualStore.getId() == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(virtualStore.getId())) {
			throw new ObjectNotFoundException("Loja Virtual", "id", virtualStore.getId());
		}
		
		virtualStoreRepository.delete(virtualStore);
	}
	
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new MissingFieldException("id", "delete");
		} else if (!existsById(id)) {
			throw new ObjectNotFoundException("Loja Virtual", "id", id);
		}
		
		virtualStoreRepository.deleteById(id);
	}

}
