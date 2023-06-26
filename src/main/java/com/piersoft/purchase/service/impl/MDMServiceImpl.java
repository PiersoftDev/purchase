package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.service.MDMService;
import com.piersoft.purchase.util.ApiClientUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MDMServiceImpl implements MDMService {

    @Autowired
    private ApiClientUtil apiClientUtil;

    @Override
    public void getCostTransaction(String projectCode, String activityCode, String itemCode) {
        String body = "{\n" +
                "  \"activity\": "+activityCode+",\n" +
                "  \"costObject\": "+itemCode+",\n" +
                "  \"projectCode\": "+projectCode+"\n" +
                "}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body );
        if(projectCode == null){
            System.out.println("request body is null");
        }
        String response = apiClientUtil.makePostCall("http://localhost:9070/v1/masters/cost-transaction/getCostTransaction", requestBody);
        System.out.println(response);
    }

    @Override
    public void getMaterialBudget(String projectCode, String activityCode, String itemCode) {
        String body = "{\n" +
                "  \"activityCode\": "+activityCode+",\n" +
                "  \"itemCode\": "+itemCode+",\n" +
                "  \"projectCode\": "+projectCode+"\n" +
                "}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body );
        String response = apiClientUtil.makePostCall("http://localhost:9070/v1/masters/material-budget/getMaterialBudget", requestBody);
        System.out.println(response);
    }
}
