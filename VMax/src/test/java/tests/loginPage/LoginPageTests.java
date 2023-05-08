package tests.loginPage;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.base.WebBaseTest;
import com.playwright.listeners.Common;
import com.playwright.pages.LoginPageSteps;
import com.playwright.util.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends WebBaseTest {
    Page page;
    BrowserContext browserContext;

    @Test(description = "Login to Vmax")
    @Description("Verify user is able to login to Vmax")
    @Severity(SeverityLevel.NORMAL)
    @Story("Login validation scenarios")
    public void VerifyLogin(){
        page = basePage.getPage();
        browserContext = basePage.getBrowserContext();

        LoginPageSteps loginPageSteps = new LoginPageSteps(page, browserContext);
        loginPageSteps.signInToVMax(Common.properties.get("userName"), Common.properties.get("password"));

    }

    @Test(description = "Login to Vmax")
    @Description("Verify user is able to login to Vmax")
    @Severity(SeverityLevel.NORMAL)
    @Story("Login validation scenarios")
    public void VerifyLoginPageHeadingText(){
        page = basePage.getPage();
        browserContext = basePage.getBrowserContext();

        LoginPageSteps loginPageSteps = new LoginPageSteps(page, browserContext);
        Assert.assertEquals(loginPageSteps.getLoginPageHeadingText(), Constants.LOGIN_PAGE_HEADING_TEXT, "Heading text is not as expected");

    }
}
