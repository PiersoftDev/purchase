package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import com.piersoft.purchase.persistence.repositories.RFQRepository;
import com.piersoft.purchase.service.RFQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RFQServiceImpl implements RFQService {

    @Autowired
    private RFQRepository rfqRepository;


    @Override
    public void createRFQ(RequestForQuotation requestForQuotation) {
        rfqRepository.save(requestForQuotation);
    }

    @Override
    public List<RequestForQuotation> listAllRFQs() {
        return (List<RequestForQuotation>)rfqRepository.findAll();
    }

    @Override
    public List<RequestForQuotation> listAllRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId) {
        return (List<RequestForQuotation>)rfqRepository.findAllByProjectCodeAndCategoryId(projectCode, categoryId);
    }
}
