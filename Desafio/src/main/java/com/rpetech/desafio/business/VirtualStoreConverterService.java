package com.rpetech.desafio.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rpetech.desafio.model.VirtualStore;
import com.rpetech.desafio.presentation.dto.VirtualStoreDto;

@Service
public class VirtualStoreConverterService {
	
	public VirtualStore dtoToVirtualStore(VirtualStoreDto dto) {
		if (dto != null) {
			VirtualStore entity = new VirtualStore(dto.getId(), dto.getCnpj(), dto.getName(), dto.getSegment(), dto.getTelephone(), dto.getUrlVirtualStore(), dto.getAssessment());
			
			return entity;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public VirtualStoreDto virtualStoreToDto(VirtualStore entity) {
		if (entity != null) {
			VirtualStoreDto dto = new VirtualStoreDto(entity.getId(), entity.getCnpj(), entity.getName(), entity.getSegment(), entity.getTelephone(), entity.getUrlVirtualStore(), entity.getAssessment());
			
			return dto;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<VirtualStore> dtosToPhysicalsStores(List<VirtualStoreDto> dtoList) {

		if (dtoList != null) {
			List<VirtualStore> entityList = new ArrayList<>();

			VirtualStore entity = null;

			if (dtoList != null && !dtoList.isEmpty()) {
				for (VirtualStoreDto dto : dtoList) {
					entity = dtoToVirtualStore(dto);
					entityList.add(entity);
				}
			}

			return entityList;
		}

		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<VirtualStoreDto> virtualsStoresToDtos(List<VirtualStore> entityList) {
		if (entityList != null) {
			List<VirtualStoreDto> dtoList = new ArrayList<>();
			
			VirtualStoreDto dto = null;
			
			if (!entityList.isEmpty()) {
				for (VirtualStore virtualStore: entityList) {
					dto = virtualStoreToDto(virtualStore);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}

	

}
