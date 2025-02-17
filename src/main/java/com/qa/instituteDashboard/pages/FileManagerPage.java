package com.qa.instituteDashboard.pages;

import com.beust.ah.A;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import com.qa.instituteDashboard.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileManagerPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;

    private By fileManagerText = By.xpath("//div[contains(text(),'File Manager')]");
    private By colomnList = By.cssSelector("div.sc-gEvEer  div.sc-eqUAAy  div.sc-fqkvVR ");
    private By fetchMoreBtn = By.xpath("//button[contains(text(),'Fetch More Records')]");
    private By fileNameText = By.cssSelector("div.sc-cwHptR.hmdZnu");
    private By downlaodBtn = By.xpath("//button[text()='Download']");
    private By downloadHeader = By.xpath("//div[text()='Download']");

    public FileManagerPage(WebDriver driver){
        this.driver =driver;
        eleUtil = new ElementUtil(driver);
        jsUtil = new JavaScriptUtil(driver);
    }

    public String getPageUrl(){
     String Url = eleUtil.waitforURLContainsAndReturns(AppConstants.FILE_MANAGER_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
     System.out.println(Url);
     return Url;
    }

    public boolean isFileManagerHeaderExist(){
        eleUtil.waitforElementVisible(fileManagerText,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(fileManagerText);
    }
    public boolean isFetchMoreBtnExist(){
        eleUtil.waitforElementVisible(fetchMoreBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.scrollToElement(fetchMoreBtn);
        return eleUtil.isElementDisplayed(fetchMoreBtn);
    }
    public int getcolomnListHeaderCount(){
        return eleUtil.waitForElementsVisible(colomnList,AppConstants.DEFAULT_SHORT_TIME_OUT).size();
    }
    public boolean isDownloadBtnExist(){
        eleUtil.waitforElementpresence(fileNameText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(downloadHeader);
        jsUtil.scrollToPageHorizontal();
        return eleUtil.isElementDisplayed(downlaodBtn);
    }
//    public



}
