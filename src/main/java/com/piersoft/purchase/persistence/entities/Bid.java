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
public class Bid {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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
