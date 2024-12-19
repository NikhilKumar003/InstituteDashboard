package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BulkActionPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By captureBulkHeader = By.xpath("//h1[text()='Capture Bulk Payments']");
    private By capturePayButton = By.xpath("//span[text()='Capture Payments']");
    private By bulkFeeButton = By.xpath("//span[text()='Bulk Fee']");
    private By capturePayHeaderModel = By.xpath("//span[text()='Capture Payment (Bulk)']");
    private By sampleDownloadBtn = By.xpath("//span[text()='Sample Download']");
    private By uploadBtn =By.xpath("//button[text()='Upload File']");
    private By instituteErrorMsg = By.cssSelector("div.text-danger.text-left");
    private By closeBtn = By.xpath("//img[@alt='close']");

    public BulkActionPage(WebDriver driver) {
        this.driver =driver;
        eleUtil =new ElementUtil(driver);
    }
    public String getPageTitle(){
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.BULK_ACTIONS_PAGE_TITLE,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Bulk Actions Page title :"+ title);
        return title;
    }
    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.BULK_ACTIONS_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Bulk Actions Page Url :" + url);
        return url;
    }
    public boolean isBulkCaptureHeaderExist(){
        return  eleUtil.isElementDisplayed(captureBulkHeader);
    }
    public boolean isCapturePayBtnExist(){
        return  eleUtil.isElementDisplayed(capturePayButton);
    }
    public boolean isBulkFeeBtnHeaderExist(){
        return  eleUtil.isElementDisplayed(bulkFeeButton);
    }
    public boolean isSampleDownloadBtnExist(){
        eleUtil.waitforElementVisible(capturePayButton,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(capturePayHeaderModel,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        return eleUtil.isElementDisplayed(sampleDownloadBtn);

    }
    public boolean isUploadFileDownloadBtnExist(){
        eleUtil.waitforElementVisible(capturePayButton,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(capturePayHeaderModel,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(uploadBtn);
        return eleUtil.isElementDisplayed(uploadBtn);
    }
    public void closeModel(){
        eleUtil.waitforElementVisible(closeBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
    }
}
