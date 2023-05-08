package com.playwright.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListeners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
    	System.out.println("*** Test Suite "+context.getName()+" started ***");
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("*** Test Suite "+context.getName()+" ending ***");
    }

    @Override
    public void onTestStart(ITestResult result) {
    	System.out.println("*** Running test method "+result.getMethod().getMethodName()+"...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("*** Executed "+result.getMethod().getMethodName()+" test successfully...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println("*** Test "+result.getMethod().getMethodName()+" skipped...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("*** Test execution "+result.getMethod().getMethodName()+" failed...");
    }
}
