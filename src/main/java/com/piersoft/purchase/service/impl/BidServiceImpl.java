package com.piersoft.purchase.service.impl;


import com.piersoft.purchase.persistence.entities.Bid;
import com.piersoft.purchase.persistence.repositories.BidRepository;
import com.piersoft.purchase.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public void saveBids(List<Bid> bidList) {
        bidRepository.saveAll(bidList);
    }

    @Override
    public List<Bid> getBids(Long rfqId) {
        return bidRepository.findAllByRFQId(rfqId);
    }
}
