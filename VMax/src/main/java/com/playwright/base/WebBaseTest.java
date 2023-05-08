package com.playwright.base;

import com.microsoft.playwright.*;
import com.playwright.listeners.Common;
import org.testng.annotations.*;

import java.util.Collections;

import static com.playwright.util.FileReader.loadProperties;

public class WebBaseTest {

    protected BasePage basePage;
    private Browser browser;
    private BrowserContext browserContext;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "propertyFile"})
    public void setBrowserType(@Optional String browser, @Optional String propertyFile) {

        if (browser != null && !browser.trim().isEmpty()) {
            Common.browserType = browser;
        } else {
            Common.browserType = "MoonChrome";
        }

        if (propertyFile != null && !propertyFile.trim().isEmpty()) {
            Common.propertyFile = propertyFile;
        } else {
            Common.propertyFile = "playwright.properties";
        }
        
        System.out.println("Browser Type: "+Common.browserType+" property file: "+Common.propertyFile);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        Common.properties = loadProperties(Common.propertyFile);

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(Collections.singletonList("--start-maximized"));

        try {
            System.out.println("Common.browserType: "+Common.browserType);
            switch (Common.browserType){
                case "Chrome":
                    browser = Playwright.create().chromium().launch(launchOptions);
                    break;
                case "Firefox":
                    browser = Playwright.create().firefox().launch(launchOptions);
                    break;
                case "Webkit":
                    browser = Playwright.create().webkit().launch(launchOptions);
                    break;
                default:
                    browser = Playwright.create().chromium().launch(launchOptions);
                    break;
            }
        }catch (PlaywrightException e){
        	System.out.println("Exception while connecting to playwright"+ e);
        }

        browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate(Common.properties.get("baseUrl"));
        basePage = new BasePage(page, browserContext);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        basePage.close();
        browserContext.close();
        browser.close();
    }


}
