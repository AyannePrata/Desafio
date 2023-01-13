package com.rpetech.desafio.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rpetech.desafio.model.PhysicalStore;
import com.rpetech.desafio.presentation.dto.PhysicalStoreDto;

@Service
public class PhysicalStoreConverterService {
	
	public PhysicalStore dtoToPhysicalStore(PhysicalStoreDto dto) {
		if (dto != null) {
			PhysicalStore entity = new PhysicalStore(dto.getId(), dto.getCnpj(), dto.getName(), dto.getSegment(), dto.getTelephone(), dto.getAddress(), dto.getNumberEmployees());
			
			return entity;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public PhysicalStoreDto physicalStoreToDto(PhysicalStore entity) {
		if (entity != null) {
			PhysicalStoreDto dto = new PhysicalStoreDto(entity.getId(), entity.getCnpj(), entity.getName(), entity.getSegment(), entity.getTelephone(), entity.getAddress(), entity.getNumberEmployees());
			
			return dto;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<PhysicalStore> dtosToPhysicalsStores(List<PhysicalStoreDto> dtoList) {

		if (dtoList != null) {
			List<PhysicalStore> entityList = new ArrayList<>();

			PhysicalStore entity = null;

			if (dtoList != null && !dtoList.isEmpty()) {
				for (PhysicalStoreDto dto : dtoList) {
					entity = dtoToPhysicalStore(dto);
					entityList.add(entity);
				}
			}

			return entityList;
		}

		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<PhysicalStoreDto> physicalsStoresToDtos(List<PhysicalStore> entityList) {
		if (entityList != null) {
			List<PhysicalStoreDto> dtoList = new ArrayList<>();
			
			PhysicalStoreDto dto = null;
			
			if (!entityList.isEmpty()) {
				for (PhysicalStore physicalStore: entityList) {
					dto = physicalStoreToDto(physicalStore);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}

}
