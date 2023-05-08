package com.playwright.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.playwright.base.BasePage;
import com.playwright.objectRepo.HomePageLocatores;
import io.qameta.allure.Step;

public class HomePageSteps extends BasePage {

    public HomePageSteps(Page page, BrowserContext browserContext) {
        super(page, browserContext);
    }

    @Step("Verify user navigated to home page")
    public boolean verifyHomePageNavigation(){
        getPage().locator(HomePageLocatores.HOME_PAGE_BRAND_LOGO).isDisabled();
        return getPage().locator(HomePageLocatores.HOME_PAGE_BRAND_LOGO).isVisible();
    }

    @Step("Get brand logo text")
    public String getBrandText(){
        return getPage().locator(HomePageLocatores.HOME_PAGE_BRAND_LOGO).getAttribute("alt").trim();
    }

    @Step("Enter search term in searchbar")
    public void inputSearchTermInSearchbar(String searchTerm){
        getPage().locator(HomePageLocatores.HOME_PAGE_SEARCHBAR).click();
        getPage().locator(HomePageLocatores.HOME_PAGE_SEARCHBAR).fill(searchTerm);
    }

    @Step("Click home page searchbar search button")
    public void clickSearchbarSearchButton(){
        getPage().locator(HomePageLocatores.HOME_PAGE_SEARCHBAR_BUTTON).click();
    }

    @Step("Close onboarding popup")
    public void closeOnboardingPopup(){
        getPage().frameLocator(HomePageLocatores.HOME_PAGE_ONBOARDING_POPUP).locator(HomePageLocatores.HOME_PAGE_ONBOARDING_POPUP_CLOSE_BUTTON).click(new Locator.ClickOptions().setTimeout(10000));
    }

}
