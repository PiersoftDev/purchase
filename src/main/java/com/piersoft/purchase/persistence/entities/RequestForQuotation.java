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
public class RequestForQuotation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String projectId;
    private String projectDesc;
    private String categoryId;
    private String categoryDesc;
    private LocalDate plannedDate;
    private String warehouseId;
    private String warehouseDesc;
    private String status;
    private LocalDate createdDate;
}
