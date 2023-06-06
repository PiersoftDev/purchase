package com.piersoft.purchase.controller;


import com.piersoft.purchase.api.request.dto.AddMaterialIndentRequestDTO;
import com.piersoft.purchase.api.request.mapper.MaterialIndentLineMapper;
import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.service.MaterialIndentLineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/purchase/material-indent")
public class MaterialIndentController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MaterialIndentController.class);

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
        LOGGER.debug("Received request to add a material indent line");
        MaterialIndentLine materialIndentLine = materialIndentLineMapper.requestToEntity(addMaterialIndentRequestDTO);
        materialIndentLineService.addMaterialIndentLine(materialIndentLine);
        LOGGER.debug("Successfully added a material indent line");
    }

    @ApiOperation(value = "Confirm material indent request", notes = "Returns a confirmed message", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully confirmed material indent request"),
            @ApiResponse(code = 404, message = "Not found - order not found")
    })
    @PostMapping(value = "/confirm/{orderId}")
    public void submitMaterialIndentRequest(@PathVariable String orderId){
        LOGGER.debug("Received request to confirm material indent request");
        materialIndentLineService.submitMaterialIndentRequest(orderId);
        LOGGER.debug("Successfully confirmed material indent request");
    }

    @ApiOperation(value = "Fetch all the active material indent lines", notes = "Returns a list of active lines", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLines(){
        LOGGER.debug("Received request to fetch all the active material indent lines");
        List<MaterialIndentLine> materialIndentLines =  materialIndentLineService.fetchAllActiveMaterialIndentLines();
        LOGGER.debug("Successfully fetched all the active material indent lines");
        return ResponseEntity.ok(materialIndentLines);
    }

    @ApiOperation(value = "Fetch all the active material indent lines", notes = "Returns a list of active lines", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/{orderId}")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLinesForOrderId(@PathVariable String orderId){
        LOGGER.debug("Received request to fetch all the active material indent lines for order id: " + orderId);
        List<MaterialIndentLine> materialIndentLines =  materialIndentLineService.fetchAllActiveMaterialIndentLinesForOrderId(orderId);
        LOGGER.debug("Successfully fetched all the active material indent lines for order id: " + orderId);
        return ResponseEntity.ok(materialIndentLines);
    }

    @ApiOperation(value = "Fetch all the active material indent lines for a project code and category id", notes = "Returns a list of active lines filtered by project code and category id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched the material lines"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @GetMapping(value = "/{projectCode}/{categoryId}")
    public ResponseEntity<List<MaterialIndentLine>> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(@PathVariable String projectCode, @PathVariable String categoryId){
        LOGGER.debug("Received request to fetch all the active material indent lines for project code: " + projectCode + " and category id: " + categoryId);
        List<MaterialIndentLine> materialIndentLines =  materialIndentLineService.fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(projectCode, categoryId);
        LOGGER.debug("Successfully fetched all the active material indent lines for project code: " + projectCode + " and category id: " + categoryId);
        return ResponseEntity.ok(materialIndentLines);
    }

           
    @ApiOperation(value = "Update material indent line status and sub status", notes = "Returns a success message", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the material line status and sub status"),
            @ApiResponse(code = 500, message = "Internal server error - failed to update the material line status and sub status"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @PutMapping(value = "/{lineId}/{status}/{subStatus}")
    public ResponseEntity<List<MaterialIndentLine>> updateMaterialIndentLineStatusAndSubStatus(@PathVariable Long lineId, @PathVariable String status, @PathVariable String subStatus){
        LOGGER.debug("Updating material indent line status and sub status" );
        materialIndentLineService.updateMaterialIndentLineStatusAndSubStatus(lineId, status, subStatus);
        LOGGER.debug("Updated material indent line status and sub status" );
        return ResponseEntity.ok(materialIndentLineService.fetchAllActiveMaterialIndentLines());
    }

    @ApiOperation(value = "Update material indent line sub status", notes = "Returns a success message", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the material line sub status"),
            @ApiResponse(code = 500, message = "Internal server error - failed to update the material line sub status"),
            @ApiResponse(code = 404, message = "Not found - no lines found")
    })
    @PutMapping(value = "/{lineId}/{subStatus}")
    public ResponseEntity<List<MaterialIndentLine>> updateMaterialIndentLineSubStatus(@PathVariable Long lineId, @PathVariable String subStatus){
        LOGGER.debug("Updating material indent line sub status to: "+subStatus );
        materialIndentLineService.updateMaterialIndentLineSubStatus(lineId, subStatus);
        LOGGER.debug("Updated material indent line sub status to: "+subStatus );
        return ResponseEntity.ok(materialIndentLineService.fetchAllActiveMaterialIndentLines());
    }


}
