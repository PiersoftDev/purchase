package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;

import java.util.List;

public interface RFQService {

    void createRFQ(RequestForQuotation requestForQuotation);
    
    List<RequestForQuotation> listAllRFQs();

    List<RequestForQuotation> listAllRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId);
}
