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


    public Leo1CardPage(WebDriver driver) {
        this.driver=driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.LEO1_CARD_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Leo1 Card page url :"+ url);
        return url;
    }
    public boolean isDownloadTemplateBtn(){
     return eleUtil.isElementDisplayed(downloadTemplateBtn);
    }

    public boolean isUploadExcelBtn(){
        return eleUtil.isElementDisplayed(uploadExcelBtn);
    }

    public boolean isdownloadTableBtn(){
       return eleUtil.isElementDisplayed(downloadTableBtn);
    }

}
