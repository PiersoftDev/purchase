package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.persistence.repositories.MaterialIndentLineRepository;
import com.piersoft.purchase.service.MDMService;
import com.piersoft.purchase.service.MaterialIndentLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialIndentLineServiceImpl implements MaterialIndentLineService {

    @Autowired
    private MaterialIndentLineRepository materialIndentLineRepository;

    @Autowired
    private MDMService mdmService;

    @Override
    public void addMaterialIndentLine(MaterialIndentLine materialIndentLine) {
        mdmService.getCostTransaction(materialIndentLine.getProjectId(), materialIndentLine.getActivityId(), materialIndentLine.getItemId());
        mdmService.getMaterialBudget(materialIndentLine.getProjectId(), materialIndentLine.getCategoryId(), materialIndentLine.getItemId());
        materialIndentLineRepository.save(materialIndentLine);
    }

    @Override
    public void submitMaterialIndentRequest(String orderId) {
        materialIndentLineRepository.updateMaterialIndentLineStatus(orderId,"Item Requested","NEW");
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLines() {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLines("Delivered");
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForOrderId(String orderId) {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForOrderId(orderId);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(String projectCode, String categoryId) {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(projectCode, categoryId);
    }

    @Override
    public void updateMaterialIndentLineStatusAndSubStatus(Long lineId, String status, String subStatus) {
        materialIndentLineRepository.updateMaterialIndentLineStatusAndSubStatus(lineId, status, subStatus);
    }

    @Override
    public void updateMaterialIndentLineSubStatus(Long lineId, String subStatus) {
        materialIndentLineRepository.updateMaterialIndentLineSubStatus(lineId, subStatus);
    }

    @Override
    public void updateMaterialIndentLineComments(Long lineId, String subStatus, String comments) {
        materialIndentLineRepository.updateMaterialIndentLineComments(lineId, subStatus, comments);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectIdAndCategory(String projectId, String categoryId) {
       return materialIndentLineRepository.fetchAllActivePurchaseMaterialIndentLinesForProjectIdAndCategory(projectId, categoryId);

    }

    @Override
    public void addMaterialIndentLinesToRfq(Long rfqId, List<Long> lineIds) {
        materialIndentLineRepository.addMaterialIndentLinesToRfq(rfqId, lineIds);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqId(Long rfqId) {
        return  materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForRfqId(rfqId);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfq() {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForRfq();
    }

    @Override
    public void updateRFQStatusToApproveByRFQId(Long rfqId) {
        materialIndentLineRepository.updateRFQStatusToApproveByRFQId(rfqId);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqApprovedByRFQId(Long rfqId) {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForRfqApproved(rfqId);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForRfqApproved() {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForRfqApproved();
    }

}
