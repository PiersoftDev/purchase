package com.piersoft.purchase.api.request.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateASNDTO {

    private String warehouseId;
    private String warehouseDesc;
    private String shipmentNumber;
    private LocalDate shipmentDate;
    private String shipmentMode;
    private String carrierAWB;
    private LocalDate deliveryDate;
    private String driverContact;
    private String driverName;
    private String vehicleNumber;
    private String businessPartnerId;
    private String businessPartnerDesc;
    //private List<DeliveryLineDTO> deliveryLines;
}
