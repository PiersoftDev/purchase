package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.Bid;

import java.util.List;

public interface BidService {

     void saveBids(List<Bid> bidList);

     List<Bid> getBids(Long rfqId);
}
