package com.piersoft.purchase.persistence.repositories;

import com.piersoft.purchase.persistence.entities.Bid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface BidRepository extends CrudRepository<Bid, Long> {

    @Query("select e  from Bid e  WHERE rfqId = :rfqId")
    List<Bid> findAllByRFQId(Long rfqId);

//    // write a query to get top 3 bids for each line item in a RFQ based on the lowest price
//    @Query
}
