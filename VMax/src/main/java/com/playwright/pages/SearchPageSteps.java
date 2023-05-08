package com.playwright.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.playwright.base.BasePage;
import com.playwright.objectRepo.SearchPageLocators;
import io.qameta.allure.Step;

public class SearchPageSteps extends BasePage {

    public SearchPageSteps(Page page, BrowserContext browserContext) {
        super(page, browserContext);
    }

    @Step("Get search result listing page url")
    public String getSearchPageUrl(){
        return getPage().url();
    }
    @Step("Verify user is on search result listing page")
    public boolean verifyUserOnSearchListingPage(){
        return getPage().waitForSelector(SearchPageLocators.SEARCH_PAGE_PRODUCT_LISTING, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.ATTACHED)).isVisible();
    }
}
