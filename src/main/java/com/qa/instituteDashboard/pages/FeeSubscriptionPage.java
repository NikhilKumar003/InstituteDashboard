package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.plaf.PanelUI;

public class FeeSubscriptionPage {
    private WebDriver driver;
    private ElementUtil eleUtil;


    private By reportsBtn = By.xpath("//span[contains(text(),'Reports')]");
    private By studentActivityBtn = By.xpath("//span[contains(text(),'Student Activity')]");
    private By feeRegistrationHeader = By.cssSelector("span.f-30.tx-semibold");
    private By searchBtn = By.cssSelector("input#search-input");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By mandateDropDown = By.cssSelector("div.css-hlgwow");


    public FeeSubscriptionPage(WebDriver driver){
        this.driver=driver;
        eleUtil =new ElementUtil(driver);
    }
    public String getPageUrl(){
        String Url= eleUtil.waitforURLContainsAndReturns(AppConstants.FEE_SUBSCRIPTION_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(Url);
        return Url;
    }
    public boolean isFeeSubscriptionHeaderExist(){
        eleUtil.waitforElementVisible(feeRegistrationHeader,AppConstants.DEFAULT_LONG_TIME_OUT);
        return eleUtil.isElementDisplayed(feeRegistrationHeader);
    }
    public boolean isSearchFieldExist(){
        eleUtil.waitforElementpresence(searchBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(searchBtn);
    }
    public boolean isMandateDropDownExist(){
        eleUtil.waitforElementpresence(mandateDropDown,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        return eleUtil.isElementDisplayed(mandateDropDown);
    }




}
