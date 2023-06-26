package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import com.piersoft.purchase.persistence.repositories.RFQRepository;
import com.piersoft.purchase.service.RFQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RFQServiceImpl implements RFQService {

    @Autowired
    private RFQRepository rfqRepository;


    @Override
    public RequestForQuotation createRFQ(RequestForQuotation requestForQuotation) {
       return rfqRepository.save(requestForQuotation);
    }

    @Override
    public List<RequestForQuotation> listAllRFQs() {
        return (List<RequestForQuotation>)rfqRepository.findByOrderByIdDesc();
    }

    @Override
    public List<RequestForQuotation> listAllRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId) {
        return (List<RequestForQuotation>)rfqRepository.findAllByProjectCodeAndCategoryId(projectCode, categoryId);
    }

    @Override
    public List<RequestForQuotation> listAllDraftedRFQsForProjectCodeAndCategoryId(String projectCode, String categoryId) {
        return (List<RequestForQuotation>)rfqRepository.findDraftedRFQsByProjectCodeAndCategoryId(projectCode, categoryId);
    }

    @Override
    public RequestForQuotation getRFQDetailsByRFQId(Long rfqId) {
        Optional<RequestForQuotation> rfq = rfqRepository.findById(rfqId);
        if(rfq.isPresent())
            return rfq.get();
        else
            return null;

    }

    @Override
    public void approveRFQByRFQId(Long rfqId) {
        rfqRepository.approveRFQById(rfqId);
    }
}
