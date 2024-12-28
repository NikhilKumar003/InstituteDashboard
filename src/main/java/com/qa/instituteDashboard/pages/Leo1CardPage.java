package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

public class Leo1CardPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By downloadTemplateBtn = By.xpath("//button[contains(text(),'Download Template')]");
    private By uploadExcelBtn = By.xpath("//span[contains(text(),'Upload excel')]");
    private By downloadTableBtn = By.xpath("//button[contains(text(),'Download table')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Reset')]");
    private By showBtn = By.cssSelector("#MainScrollbar > div:nth-child(4) > div >div >a >u");
    private By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
    private By clearBtn = By.xpath("//button[contains(text(),'Clear')]");
    private By mobileNoText = By.xpath("//input[@placeholder='Mobile No.']");
    private By deliverStudentBtn = By.xpath("//button[contains(text(),'Delivered to student:')]");
    private By checkBoxBtn = By.xpath("//*[@id=\"cell-1-undefined\"]/div/div/input");
    private By fetchMoreBtn = By.xpath("//button[contains(text(),'Fetch More Records')]");

    public Leo1CardPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getPageUrl() {
        String url = eleUtil.waitforURLContainsAndReturns(AppConstants.LEO1_CARD_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Leo1 Card page url :" + url);
        return url;
    }

    public boolean isDownloadTemplateBtn() {
        return eleUtil.isElementDisplayed(downloadTemplateBtn);
    }

    public boolean isUploadExcelBtn() {
        return eleUtil.isElementDisplayed(uploadExcelBtn);
    }

    public boolean isdownloadTableBtn() {
        return eleUtil.isElementDisplayed(downloadTableBtn);
    }
    public boolean isResetBtn() {
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean isSubmitAndClearBtn() {
        eleUtil.waitforElementVisible(showBtn, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(submitBtn);
        return eleUtil.isElementDisplayed(submitBtn);
    }
    public void isFetchMoreBtnExist(){
        eleUtil.waitforElementVisible(checkBoxBtn,AppConstants.DEFAULT_LONG_TIME_OUT);
        eleUtil.scrollToElement(fetchMoreBtn);
    }
    public void verifyAllUsersLoaded(){
        eleUtil.waitforElementVisible(showBtn, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(submitBtn);
        eleUtil.doClick(showBtn);
        eleUtil.waitforElementVisible(checkBoxBtn,AppConstants.DEFAULT_LONG_TIME_OUT);
        eleUtil.scrollToElement(checkBoxBtn);
        eleUtil.doClick(checkBoxBtn);
    }

    public void checkUserWithMobile(){
        eleUtil.waitforElementVisible(showBtn, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(submitBtn);
        eleUtil.waitforElementVisible(mobileNoText,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys("7842290549");
        eleUtil.waitforElementVisible(submitBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
//        eleUtil.scrollToElement(deliverStudentBtn);
    }

}