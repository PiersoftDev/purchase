package com.piersoft.purchase.api.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryLineDTO {

    private Long lineId;
    private String itemId;
    private String itemDesc;
    private Double orderedQuantity;
    private Double shippingQuantity;
    private Long poId;

}
