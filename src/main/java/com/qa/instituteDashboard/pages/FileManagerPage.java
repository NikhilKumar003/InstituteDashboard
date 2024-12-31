package com.qa.instituteDashboard.pages;

import com.beust.ah.A;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileManagerPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By fileManagerText = By.xpath("//div[contains(text(),'File Manager')]");
    private By colomnList = By.cssSelector("div.sc-gEvEer  div.sc-eqUAAy  div.sc-fqkvVR ");


    public FileManagerPage(WebDriver driver){
        this.driver =driver;
        eleUtil = new ElementUtil(driver);
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



}
