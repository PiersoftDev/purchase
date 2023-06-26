package com.piersoft.purchase.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MaterialIndentLine {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String orderId;
    private String itemId;
    private String itemDesc;
    private String categoryId;
    private String category;
    private Double quantity;
    private String uom;
    private LocalDateTime plannedDate;
    private String projectId;
    private String projectDesc;
    private String activityId;
    private String activityDesc;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedTime;
    private Double budgetedQty;
    private Double inventory;
    private Double procuredTillDate;
    private String userId;
    private String username;
    private Double cmp;
    private Double variance;
    private String status;
    private String subStatus;
    private Long woId;
    private Long prId;
    private Long rfqId;
    private Long poId;
    private String comments;

}
