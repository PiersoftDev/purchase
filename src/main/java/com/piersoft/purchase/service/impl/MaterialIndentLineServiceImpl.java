package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.persistence.repositories.MaterialIndentLineRepository;
import com.piersoft.purchase.service.MaterialIndentLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialIndentLineServiceImpl implements MaterialIndentLineService {

    @Autowired
    private MaterialIndentLineRepository materialIndentLineRepository;

    @Override
    public void addMaterialIndentLine(MaterialIndentLine materialIndentLine) {
        materialIndentLineRepository.save(materialIndentLine);
    }

    @Override
    public void submitMaterialIndentRequest(String orderId) {
        materialIndentLineRepository.updateMaterialIndentLineStatus(orderId,"NEW");
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLines() {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLines("NEW");
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForOrderId(String orderId) {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForOrderId(orderId);
    }

    @Override
    public List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(String projectCode, String categoryId) {
        return materialIndentLineRepository.fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(projectCode, categoryId);
    }
}