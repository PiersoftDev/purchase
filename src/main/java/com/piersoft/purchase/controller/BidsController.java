package com.piersoft.purchase.controller;

import com.piersoft.purchase.api.request.dto.CreateBidDTO;
import com.piersoft.purchase.api.request.mapper.CreateBidMapper;
import com.piersoft.purchase.persistence.entities.Bid;
import com.piersoft.purchase.service.BidService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rest controller for managing bids
@RestController
@RequestMapping("/v1/purchase/bids")
public class BidsController {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BidsController.class);

    @Autowired
    private BidService bidService;

    @Autowired
    private CreateBidMapper createBidMapper;

    // API to save bids for a RFQ, which takes lineId, bid amount, bidder details and possible delivery date
    @ApiOperation(value = "Save bids for a RFQ", notes = "returns success message", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saves bids for a RFQ"),
            @ApiResponse(code = 404, message = "Not found - bid save failed")
    })
    @PostMapping(value = "/save-bids")
    public ResponseEntity<String> saveBids(@RequestBody List<CreateBidDTO> createBidDTOList){
        logger.debug("Saving bids for RFQ");
        List<Bid> bidList = createBidDTOList.stream().map(createBidDTO -> createBidMapper.toEntity(createBidDTO)).toList();
        bidService.saveBids(bidList);
        return ResponseEntity.ok("Bids saved successfully");
    }

    // API to pull the bids for a RFQ based on the RFQ id
    @ApiOperation(value = "Get bids for a RFQ", notes = "returns bids for a RFQ", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully gets bids for a RFQ"),
            @ApiResponse(code = 404, message = "Not found - bid get failed")
    })
    @PostMapping(value = "/get-bids/{rfqId}")
    public ResponseEntity<List<Bid>> getBids(@PathVariable Long rfqId){
        logger.debug("Getting bids for RFQ by id: {}", rfqId);
        List<Bid> bidList = bidService.getBids(rfqId);
        return ResponseEntity.ok(bidList);
    }

}
