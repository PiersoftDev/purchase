package com.piersoft.purchase.controller;


import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.api.request.dto.CreateRFQDTO;
import com.piersoft.purchase.api.request.mapper.CreateRFQMapper;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.persistence.entities.RequestForQuotation;
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

    @ApiOperation(value = "creates a rfq header", notes = "returns created rfq", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully creates an rgq header"),
            @ApiResponse(code = 404, message = "Not found - rfq creation fails")
    })
    @PostMapping(value = "/create-rfq")
    public void createRFQ(@RequestBody CreateRFQDTO createRFQDTO){
        RequestForQuotation requestForQuotation = createRFQMapper.requestToEntity(createRFQDTO);
        rfqService.createRFQ(requestForQuotation);
    }

    @ApiOperation(value = "Get all the RFQs", notes = "returns list of RFQs", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns a list of RFQs"),
            @ApiResponse(code = 404, message = "Not found - rfq fetch failed")
    })
    @GetMapping(value = "/")
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
}
