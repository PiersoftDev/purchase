package com.piersoft.purchase.api.request.mapper;

import com.piersoft.purchase.api.request.dto.CreateBidDTO;
import com.piersoft.purchase.persistence.entities.Bid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateBidMapper {

    CreateBidDTO toDTO(Bid bid);
    Bid toEntity(CreateBidDTO createBidDTO);
}
