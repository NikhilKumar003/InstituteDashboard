package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    //    1. locators
    private By email = By.xpath("//input[contains(@type,'Email')]");
    private By password = By.xpath("//input[contains(@type,'password')]");
    private By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    private By forgotBtn = By.xpath("//span[text()='Forgot password?']");
    private By logo = By.xpath("//img[@alt='logo-light']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getPageTitle() {
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("login page title :" + title);
        return title;
    }

    public String getPageURL() {
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("login page title :" + url);
        return url;
    }

    public boolean isForgotPwdLinkExist() {
        return eleUtil.isElementDisplayed(forgotBtn);
//        return driver.findElement(forgotBtn).isDisplayed();
    }

    public boolean isLogoExist() {
        return eleUtil.isElementDisplayed(logo);
//        return driver.findElement(logo).isDisplayed();
    }

    public DashBoardPage doLogin(String userName, String pwd){
      eleUtil.waitforElementVisible(email,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(userName);
      eleUtil.doSendKeys(password,pwd);
      eleUtil.doClick(loginBtn);

      return new DashBoardPage(driver);
    }

}

