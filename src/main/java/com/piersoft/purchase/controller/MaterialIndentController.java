package com.piersoft.purchase.controller;


import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.api.request.mapper.MaterialIndentLineMapper;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.service.MaterialIndentLineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/purchase/material-indent")
@CrossOrigin(origins = "http://49.43.200.226:3000")
public class MaterialIndentController {

    @Autowired
    private MaterialIndentLineMapper materialIndentLineMapper;

    @Autowired
    private MaterialIndentLineService materialIndentLineService;

    @ApiOperation(value = "Adds a material indent line", notes = "Returns a material indent line id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a material line with draft status"),
            @ApiResponse(code = 404, message = "Not found - material indent line id not available")
    })
    @PostMapping(value = "/add-material")
    public void addMaterial(@RequestBody AddMaterialIndentRequestDTO addMaterialIndentRequestDTO){
        MaterialIndentLine materialIndentLine = materialIndentLineMapper.requestToEntity(addMaterialIndentRequestDTO);
        materialIndentLineService.addMaterialIndentLine(materialIndentLine);
    }

    @ApiOperation(value = "Confirm material indent request", notes = "Returns a confirmed message", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully confirmed material indent request"),
            @ApiResponse(code = 404, message = "Not found - order not found")
    })
    @PostMapping(value = "/confirm/{orderId}")
    public void submitMaterialIndentRequest(@PathVariable String orderId){
        materialIndentLineService.submitMaterialIndentRequest(orderId);
    }

    @ApiOperation(value = "Fetch all the active material indent lines", notes = "Returns a list of active lines", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLines(){
        return ResponseEntity.ok(materialIndentLineService.fetchAllActiveMaterialIndentLines());
    }

    @ApiOperation(value = "Fetch all the active material indent lines", notes = "Returns a list of active lines", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/{orderId}")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLinesForOrderId(@PathVariable String orderId){
        return ResponseEntity.ok(materialIndentLineService.fetchAllActiveMaterialIndentLinesForOrderId(orderId));
    }

    @ApiOperation(value = "Fetch all the active material indent lines for a project code and category id", notes = "Returns a list of active lines filtered by project code and category id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/{projectCode}/{categoryId}")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(@PathVariable String projectCode, @PathVariable String categoryId){
        return ResponseEntity.ok(materialIndentLineService.fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(projectCode, categoryId));
    }

}
