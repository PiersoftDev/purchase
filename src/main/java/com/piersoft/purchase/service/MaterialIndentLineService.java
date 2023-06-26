package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.MaterialIndentLine;

import java.util.List;

public interface MaterialIndentLineService {

    void addMaterialIndentLine(MaterialIndentLine materialIndentLine);

    void submitMaterialIndentRequest(String orderId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLines();

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForOrderId(String orderId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(String projectCode, String categoryId);

    void updateMaterialIndentLineStatusAndSubStatus(Long lineId, String status, String subStatus);

    void updateMaterialIndentLineSubStatus(Long lineId, String subStatus);

    void updateMaterialIndentLineComments(Long lineId, String subStatus, String comments);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectIdAndCategory(String projectId, String categoryId);

    void addMaterialIndentLinesToRfq(Long rfqId, List<Long> lineIds);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqId(Long rfqId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfq();

    void updateRFQStatusToApproveByRFQId(Long rfqId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqApprovedByRFQId(Long rfqId);

    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqApproved();
}
