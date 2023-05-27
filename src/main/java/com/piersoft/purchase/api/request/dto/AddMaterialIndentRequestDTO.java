package com.piersoft.purchase.api.request.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMaterialIndentRequestDTO {

    private String orderId;
    private String projectId;
    private String projectDesc;
    private String activityId;
    private String activityDesc;
    private String itemId;
    private String itemDesc;
    private String categoryId;
    private String category;
    private Double quantity;
    private String uom;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime plannedDate;
    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedTime;
    private Double budgetedQty = new Random().nextDouble();
    private Double inventory = new Random().nextDouble();
    private Double procuredTillDate = new Random().nextDouble();
    private String userId;
    private String username;
    private Double cmp ;
    private Double variance;
    private String status;
    private String subStatus;
    private String woId;
    private String prId;
    private String rfqId;
    private String poId;

}
