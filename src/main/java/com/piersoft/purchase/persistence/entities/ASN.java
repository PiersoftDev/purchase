package com.piersoft.purchase.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ASN {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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

}
