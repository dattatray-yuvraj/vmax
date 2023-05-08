package com.playwright.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.base.BasePage;
import com.playwright.objectRepo.LoginPageLocators;

public class LoginPageSteps extends BasePage {


    public LoginPageSteps(Page page, BrowserContext browserContext) {
        super(page, browserContext);
    }

    //Verify user on login page
    //Verify the heading text
    //Verify the sub-heading text
    //Input username
    // Input password
    //Click on sign in

    //Sign in to xyz website


    public boolean verifyUserIsOnLoginPage(){
        return getPage().locator(LoginPageLocators.LOGIN_PAGE_HEADING).isDisabled();
    }

    public String getLoginPageHeadingText(){
        return getPage().locator(LoginPageLocators.LOGIN_PAGE_HEADING).innerText();
    }

    public String getLoginPageSubHeadingText(){
        return getPage().locator(LoginPageLocators.LOGIN_PAGE_SUB_HEADING).innerText();
    }

    public void inputUserName(String userName){
        getPage().locator(LoginPageLocators.LOGIN_PAGE_USERNAME_INPUT).fill(userName);
    }

    public void inputPassword(String password){
        getPage().locator(LoginPageLocators.LOGIN_PAGE_PASSWORD_INPUT).fill(password);
    }

    public void clickOnSignIn(){
        getPage().locator(LoginPageLocators.LOGIN_PAGE_SIGNIN_BUTTON).click();
    }


    public void signInToVMax(String userName, String password){
        inputUserName(userName);
        inputPassword(password);
        clickOnSignIn();
    }




}
