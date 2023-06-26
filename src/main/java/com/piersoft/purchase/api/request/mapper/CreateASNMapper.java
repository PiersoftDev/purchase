package com.piersoft.purchase.api.request.mapper;


import com.piersoft.purchase.api.request.dto.CreateASNDTO;
import com.piersoft.purchase.persistence.entities.ASN;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateASNMapper {
    ASN toEntity(CreateASNDTO createASNDTO);

    CreateASNDTO toDTO(ASN asn);
}
