package com.piersoft.purchase.api.request.mapper;

import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialIndentLineMapper {

    MaterialIndentLine requestToEntity(AddMaterialIndentRequestDTO addMaterialIndentRequestDTO);
}
