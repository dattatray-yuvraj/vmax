package com.playwright.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import static com.playwright.util.FileReader.loadProperties;

public class SuiteListeners implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Invoking suite:"+suite.getName());
        Common.properties = loadProperties(suite.getParameter("propertyFile"));
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finished suite "+suite.getName()+" with results:"+suite.getResults());
    }
}
