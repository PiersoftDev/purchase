package com.piersoft.purchase.controller;


import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.api.request.dto.CreateRFQDTO;
import com.piersoft.purchase.api.request.mapper.CreateRFQMapper;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import com.piersoft.purchase.service.MaterialIndentLineService;
import com.piersoft.purchase.service.RFQService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/purchase/rfq")
public class RFQController {

    @Autowired
    private CreateRFQMapper createRFQMapper;

    @Autowired
    private RFQService rfqService;

    @Autowired
    private MaterialIndentLineService materialIndentLineService;

    @ApiOperation(value = "creates a rfq header", notes = "returns created rfq", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully creates an rgq header"),
            @ApiResponse(code = 404, message = "Not found - rfq creation fails")
    })
    @PostMapping(value = "/create-rfq")
    public ResponseEntity<RequestForQuotation> createRFQ(@RequestBody CreateRFQDTO createRFQDTO){
        RequestForQuotation requestForQuotation = createRFQMapper.requestToEntity(createRFQDTO);
        requestForQuotation =  rfqService.createRFQ(requestForQuotation);
        return ResponseEntity.ok(requestForQuotation);
    }

    @ApiOperation(value = "Get all the RFQs", notes = "returns list of RFQs", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns a list of RFQs"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/list-all-rfqs")
    public ResponseEntity<List<RequestForQuotation>> listAllRFQs(){
        return ResponseEntity.ok(rfqService.listAllRFQs());
    }

    @ApiOperation(value = "Get all the RFQs", notes = "returns list of RFQs", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns a list of RFQs"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/{projectCode}/{categoryId}")
    public ResponseEntity<List<RequestForQuotation>> listAllRFQsForProjectCodeAndCategoryId(@PathVariable String projectCode, @PathVariable String categoryId){
        return ResponseEntity.ok(rfqService.listAllRFQsForProjectCodeAndCategoryId(projectCode, categoryId));
    }

    // get all RFQs with drafted status by project id and catergory id
    @ApiOperation(value = "Get all the RFQs for requested project id and category id", notes = "returns list of drafted RFQs", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns a list of RFQs that are in draft status for a project and category"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/drafted/{projectCode}/{categoryId}")
    public ResponseEntity<List<RequestForQuotation>> listAllDraftedRFQsForProjectCodeAndCategoryId(@PathVariable String projectCode, @PathVariable String categoryId){
        return ResponseEntity.ok(rfqService.listAllDraftedRFQsForProjectCodeAndCategoryId(projectCode, categoryId));
    }

    // get RFQ details by rfq id
    @ApiOperation(value = "Get RFQ details for requested rfq id", notes = "returns RFQ details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns RFQ details"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/search/{rfqId}")
    public ResponseEntity<RequestForQuotation> getRFQDetailsByRFQId(@PathVariable Long rfqId){
        RequestForQuotation rfq = rfqService.getRFQDetailsByRFQId(rfqId);
        if(rfq == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rfq);
    }

    // Approve RFQ by rfq id
    @ApiOperation(value = "Approve RFQ for requested rfq id", notes = "returns RFQ details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns RFQ details"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/approve/{rfqId}")
    public void approveRFQ(@PathVariable Long rfqId){
        rfqService.approveRFQByRFQId(rfqId);
        materialIndentLineService.updateRFQStatusToApproveByRFQId(rfqId);
    }


}
