package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryLoansPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By createApplicationBtn= By.xpath("//span[text()='Create application']");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By loanSummaryHeader = By.xpath("//span[text()='Loan Applications Summary']");
    private By submitBtn = By.xpath("//button[text()='Submit']");

    SummaryLoansPage(WebDriver driver){
        this.driver =driver;
        eleUtil =new ElementUtil(driver);
    }

    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.DASHBOARD_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Dashboard Page Url :" + url);
        return url;
    }
    public boolean isCreateApplicationExist(){
        return eleUtil.isElementDisplayed(createApplicationBtn);
    }
    public boolean isResetBtnExist(){
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean setCreateApplicationBtn(){
        eleUtil.waitforElementpresence(createApplicationBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return eleUtil.isElementDisplayed(submitBtn);
    }
    public boolean isLoanSummaryHeaderExist(){
        return eleUtil.isElementEnabled(loanSummaryHeader);
    }

}
