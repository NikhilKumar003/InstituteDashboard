package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import com.qa.instituteDashboard.utils.JavaScriptUtil;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class FeeSubscriptionPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;


    private By reportsBtn = By.xpath("//span[contains(text(),'Reports')]");
    private By studentActivityBtn = By.xpath("//span[contains(text(),'Student Activity')]");
    private By feeRegistrationHeader = By.cssSelector("span.f-30.tx-semibold");
    private By searchBtn = By.cssSelector("input#search-input");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By mandateDropDown = By.cssSelector("div.css-hlgwow");
    private By colomnsList= By.cssSelector("div[role='columnheader'] > div.sc-cwHptR.hmdZnu");
    private By messageBtn = By.cssSelector("px-2 py-2 cursor-pointer");
    private By checkBox = By.cssSelector("form-check-input");


    public FeeSubscriptionPage(WebDriver driver){
        this.driver=driver;
        eleUtil =new ElementUtil(driver);
        jsUtil = new JavaScriptUtil(driver);
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
    public boolean isResetBtnExist(){
        eleUtil.waitforElementpresence(resetBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public int getColomnListHeaderCount(){
      return  eleUtil.waitForElementsVisible(colomnsList,AppConstants.DEFAULT_LONG_TIME_OUT).size();
    }
    public List<String> getClomnListHeaderList(){
        List<WebElement> headerList= eleUtil.waitForElementsVisible(colomnsList,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List<String> headerListText = new ArrayList<String>();
        for(WebElement e : headerList){
            String headerText= e.getText();
            headerListText.add(headerText);
        }
        return headerListText;
    }
    public boolean isMessageBtnExist(){
        eleUtil.waitforElementpresence(checkBox, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(messageBtn);
        jsUtil.scrollToPageHorizontal();
        return eleUtil.isElementDisplayed(messageBtn);
    }




}
