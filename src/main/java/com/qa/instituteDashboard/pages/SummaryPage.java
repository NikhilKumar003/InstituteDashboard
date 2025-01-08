package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By feeSummaryHeader = By.xpath("//h1[text()='Fee Summary - Overall']");
//    private By

    public SummaryPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getPageUrl(){
        String Url =eleUtil.waitforURLContainsAndReturns(AppConstants.DASHBOARD_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Student Summary page title :"+ Url);
        return Url;

    }

    public boolean isFeeSummaryHeaderExist(){
        eleUtil.waitforElementVisible(feeSummaryHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(feeSummaryHeader);
    }

}
