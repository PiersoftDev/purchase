package com.piersoft.purchase.api.request.mapper;

import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.api.request.dto.CreateRFQDTO;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateRFQMapper {

    RequestForQuotation requestToEntity(CreateRFQDTO  createRFQDTO);

}
