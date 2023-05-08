package com.piersoft.purchase.api.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRFQDTO {

    private String projectId;
    private String ProjectCode;
    private String categoryId;
    private String category;
    private LocalDate plannedDate;
    private String warehouseId;
    private String warehouseCode;

}
