package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoinsRequestPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By coinRequestHeader = By.xpath("//h1[text()='Student Coin Requests']");
    private By downloadSampleTemplateBtn = By.xpath("//span[contains(text(),'Download Sample')]");
    private By downloadPendingTemplateBtn = By.xpath("//span[contains(text(),'Download All Pending')]");
    private By uploadBulkTransactionBtn = By.xpath("//span[contains(text(),'Upload Bulk')]");

    public CoinsRequestPage(WebDriver driver) {
        this.driver =driver;
        eleUtil =new ElementUtil(driver);
    }

    public String getPageTitle() {
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.COINS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Student List page title :" + title);
        return title;
    }
    public String getPageUrl(){
        String Url=  eleUtil.waitforURLContainsAndReturns(AppConstants.COINS_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(Url);
        return Url;
    }
    public boolean isCoinHeaderExist(){
      return eleUtil.isElementDisplayed(coinRequestHeader);

    }
    public boolean isDownloadSampleBtnExist(){
        eleUtil.waitforElementpresence(downloadSampleTemplateBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(downloadSampleTemplateBtn);
    }
    public boolean isUploadBulkBtnExist(){
        eleUtil.waitforElementpresence(uploadBulkTransactionBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(uploadBulkTransactionBtn);
    }
    public boolean isDownloadPendingBtnExist(){
        eleUtil.waitforElementpresence(downloadPendingTemplateBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(downloadPendingTemplateBtn);
    }
}
