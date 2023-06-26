package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;

import java.util.List;

public interface RFQService {

    RequestForQuotation createRFQ(RequestForQuotation requestForQuotation);
    
    List<RequestForQuotation> listAllRFQs();

    List<RequestForQuotation> listAllRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId);

    List<RequestForQuotation> listAllDraftedRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId);

    RequestForQuotation getRFQDetailsByRFQId(Long rfqId);

    void approveRFQByRFQId(Long rfqId);
}
