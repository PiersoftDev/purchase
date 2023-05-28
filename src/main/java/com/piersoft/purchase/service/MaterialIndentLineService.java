package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.MaterialIndentLine;

import java.util.List;

public interface MaterialIndentLineService {

    void addMaterialIndentLine(MaterialIndentLine materialIndentLine);

    void submitMaterialIndentRequest(String orderId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLines();

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForOrderId(String orderId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(String projectCode, String categoryId);

    void updateMaterialIndentLineStatusAndSubStatus(String lineId, String status, String subStatus);

    void updateMaterialIndentLineSubStatus(String lineId, String subStatus);
}
