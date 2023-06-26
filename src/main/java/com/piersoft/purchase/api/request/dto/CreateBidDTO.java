package com.piersoft.purchase.api.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Request DTO for creating bids
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBidDTO {

    private Long rfqId;
    private Long lineId;
    private String itemId;
    private String itemDescription;
    private Double quantity;
    private String uom;
    private String vendorId;
    private String vendorName;
    private String warehouseId;
    private String warehouseName;
    private Double unitPrice;
    private Double totalAmount;
    private String currency;
    private String status;
    private LocalDate possibleDeliveryDate;
    private LocalDate bidCreatedDate;
    private LocalDate bidUpdatedDate;

}
