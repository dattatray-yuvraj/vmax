package com.playwright.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryCount=0;
    private static final int MAX_RETRY = Integer.parseInt(Common.properties.get("testRetryCount"));
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if(retryCount < MAX_RETRY){
                retryCount++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            }else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        }else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
