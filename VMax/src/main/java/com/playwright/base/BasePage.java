package com.playwright.base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.Optional;

public class BasePage {

    Page page;
    BrowserContext browserContext;

    public BasePage(@Optional Page page, @Optional BrowserContext browserContext) {
        this.page = page;
        this.browserContext = browserContext;
    }

    public Page getPage() {
        return page;
    }

    public BrowserContext getBrowserContext() {
        return browserContext;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setBrowserContext(BrowserContext browserContext) {
        this.browserContext = browserContext;
    }

    public void close() {
        page.close();
    }


}
