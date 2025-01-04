package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StudentListPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By searchBtn = By.cssSelector("input#search-input");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By dropDownInstitute = By.cssSelector("svg.MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.f-30.css-vubbuv");
    private By colomnsList= By.cssSelector("div[role='columnheader'] > div.sc-cwHptR.hmdZnu");
    private By downloadBtn = By.xpath("//span[text()='Download All']");
    private By sendRemainderBtn = By.xpath("//button[text()='Send Reminder']");
    private By capturePayBtn = By.xpath("//button[text()='Capture Payment']");
    private By cancelBtn = By.xpath("//button[text()='Cancel']");
    private By viewFeeDetails = By.xpath("//span[text()='View/Modify']");
    private By trackBtn = By.xpath("//div[@id='cell-5-0']//p");
    private By makePaymentBtn = By.xpath("//button[contains(text(),'Make Payment')]");
    private By captureHeaderText = By.xpath("//span[contains(text(),'Capture payment')]");
    private By studentDetailsText = By.xpath("//h1[text()='Student Overall Details']");
    private By closeBtn = By.xpath("//img[@alt='close']");

    public StudentListPage(WebDriver driver){
        this.driver=driver;
        eleUtil= new ElementUtil(driver);

    }
    public String getPageTitle() {
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.STUDENT_LIST_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Student List page title :" + title);
        return title;
    }
    public String getPageUrl(){
       String Url=  eleUtil.waitforURLContainsAndReturns(AppConstants.STUDENT_LIST_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(Url);
        return Url;
    }
    public void setDownloadBtn(){
        eleUtil.waitforElementVisible(downloadBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();

    }
    public boolean isSearchFieldExist(){
        eleUtil.waitforElementpresence(searchBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(searchBtn);
    }
    public boolean isResetBtnExist(){
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean isSendRemainderExist(){
        eleUtil.waitforElementpresence(sendRemainderBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(sendRemainderBtn);
    }
    public boolean isCaptureBtnExist(){
        eleUtil.waitforElementpresence(capturePayBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(capturePayBtn);
    }
    public boolean isTrackExist(){
        eleUtil.waitforElementpresence(trackBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(trackBtn);
    }
    public boolean isCaptureHeaderExist(){
        eleUtil.waitforElementpresence(captureHeaderText,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(captureHeaderText);
    }
    public boolean isStudentOverallDetailsExist(){
        eleUtil.waitforElementpresence(studentDetailsText,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(studentDetailsText);
    }

    public boolean isInstituteDropDownExist(){
        eleUtil.waitforElementpresence(dropDownInstitute, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(dropDownInstitute);
    }
    public int getColomnListHeaderCount(){
       return  eleUtil.waitForElementsVisible(colomnsList,AppConstants.DEFAULT_SHORT_TIME_OUT).size();
        }
    public List<String> getColomnListHeaderList(){
       List<WebElement> headerList =  eleUtil.waitForElementsVisible(colomnsList, AppConstants.DEFAULT_SHORT_TIME_OUT);
       List<String> headerTextList = new ArrayList<String>();
       for (WebElement e : headerList){
           String  headerText = e.getText();
           headerTextList.add(headerText);
       }
       return headerTextList;
    }
    public boolean setSearchBtn(String mobile) throws InterruptedException {
        eleUtil.waitforElementVisible(resetBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.doClick(resetBtn);
        eleUtil.doSendKeysWithClear(driver.findElement(searchBtn),mobile);
            Thread.sleep(4000);
        return eleUtil.isElementDisplayed(capturePayBtn);

    }
    public void doClear(){
        eleUtil.doClear(searchBtn);
    }
    public boolean setCapturePayBtn(String mobile) throws InterruptedException {
        setSearchBtn(mobile);
        eleUtil.waitforElementVisible(capturePayBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(makePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(makePaymentBtn);

    }

    public boolean studentOverallDetails(String mobile) throws InterruptedException {
        setCapturePayBtn(mobile);
        eleUtil.doClick(closeBtn);
        eleUtil.waitforElementVisible(capturePayBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.waitforElementVisible(viewFeeDetails,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return eleUtil.isElementDisplayed(studentDetailsText);

    }
    public void setCloseBtn(){
        eleUtil.doClick(closeBtn);
    }
}
