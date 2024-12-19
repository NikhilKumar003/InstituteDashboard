package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanApplicationPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By loanHeader = By.xpath("//div[text()='All Loan Applications']");
    private By searchField = By.cssSelector("input#search-input");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By dropDown = By.cssSelector("div.css-hlgwow");
//    private By selectLoanStatus = By.xpath("//div[contains(@class, 'css-hlgwow')]//div[text()='Documents pending']");
    private By verifyMobile= By.cssSelector("#row-0 > #cell-4-undefined");
    private By verifyStatus= By.cssSelector("#row-0 > #cell-5-undefined");


    public LoanApplicationPage(WebDriver driver){
        this.driver =driver;
        eleUtil = new ElementUtil(driver);
    }
    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.LOANS_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("All Loans Page Url : "+ url);
        return url;
    }
    public boolean isSearchFieldExist(){
        return  eleUtil.isElementDisplayed(searchField);
    }
    public boolean isResetBtnExist(){
        return  eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean isAllLoansHeaderExist(){
        return  eleUtil.isElementDisplayed(loanHeader);
    }
    public String getSearchField(String mobile){
        eleUtil.waitforElementVisible(searchField, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(mobile);
        String mobileText =eleUtil.waitforElementVisible(verifyMobile,AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
        if(mobile.equals(mobileText)) {
            return mobileText;

        }  return mobileText;
    }

    public String getLoanStatus(String loanStatus){
      eleUtil.selectDropDownText(dropDown,loanStatus);
       return eleUtil.waitforElementVisible(verifyStatus,AppConstants.DEFAULT_LONG_TIME_OUT).getText();

    }

}
