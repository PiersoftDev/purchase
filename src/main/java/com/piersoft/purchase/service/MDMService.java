package com.piersoft.purchase.service;

public interface MDMService {

    void getCostTransaction(String projectCode, String activityCode, String itemCode);

    void getMaterialBudget(String projectCode, String activityCode, String itemCode);
}
