package tests.homePage;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.base.WebBaseTest;
import com.playwright.pages.HomePageSteps;
import com.playwright.pages.SearchPageSteps;
import com.playwright.util.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTests extends WebBaseTest {

    Page page;
    BrowserContext browserContext;

    @Test(description = "Create flow1 product with no common image and verify")
    @Description("Create flow1 product with no common image and verify")
    @Severity(SeverityLevel.NORMAL)
    @Story("Common image validation scenarios")
    public void VerifyHomePage(){
        page = basePage.getPage();
        browserContext = basePage.getBrowserContext();
        HomePageSteps homePageSteps = new HomePageSteps(page, browserContext);
        Assert.assertTrue(homePageSteps.verifyHomePageNavigation(), "Home page navigation failed");
//        Assert.assertEquals(homePageSteps.getBrandText(), Constants.HOME_PAGE_BRAND_TEXT, "Brand logo text is not as expected");
        homePageSteps.closeOnboardingPopup();
//        homePageSteps.inputSearchTermInSearchbar(Constants.SEARCH_TERM);
        homePageSteps.clickSearchbarSearchButton();

        SearchPageSteps searchPageSteps = new SearchPageSteps(page, browserContext);
        System.out.println("searchPageSteps.getSearchPageUrl(): "+searchPageSteps.getSearchPageUrl());
        Assert.assertTrue(searchPageSteps.verifyUserOnSearchListingPage(), "User is not on search result listing page");


    }
}
