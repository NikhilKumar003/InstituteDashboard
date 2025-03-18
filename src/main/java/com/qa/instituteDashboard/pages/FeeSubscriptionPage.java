package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import com.qa.instituteDashboard.utils.JavaScriptUtil;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class FeeSubscriptionPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;


    private By reportsBtn = By.xpath("//span[contains(text(),'Reports')]");
    private By studentActivityBtn = By.xpath("//span[contains(text(),'Student Activity')]");
    private By feeRegistrationHeader = By.cssSelector("span.f-30.tx-semibold");
    private By searchBtn = By.cssSelector("input#search-input");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By mandateDropDown = By.cssSelector("div.css-hlgwow");
    private By colomnsList= By.cssSelector("div[role='columnheader'] > div.sc-cwHptR.hmdZnu");
    private By messageBtn = By.cssSelector("div.px-2.py-2.cursor-pointer");
    private By checkBox = By.xpath("//input[@type='checkbox']");
    private By eyeButton = By.cssSelector("div.px-2.py-2.cursor-pointer:nth-of-type(2)");
    private By studentNameText =By.cssSelector("div.sc-cwHptR.hmdZnu");
    private By actionsHeader = By.xpath("//div[text()='Actions']");
    private By nachHeader = By.xpath("//div[contains(text(),'NACH')]");
    private By backHeader = By.xpath("//div[contains(text(),'Bank')]");
    private By pendingHeader = By.xpath("//div[contains(text(),'Registration Pending')]");
    private By closeBtn = By.xpath("//img[@alt='close']");
    private By hyperLink = By.xpath("//div[@class='p-0 w-100 text-center']/a");
    private By studentActivityHeader = By.xpath("//span[contains(text(),'Subscription - Student')]");
    private By backBtn = By.xpath("//div[@role='button']");
    private By linkBtn = By.xpath("//button[contains(text(),'Link')]");
    private By reminderHeader = By.xpath("//h2[contains(text(),'Send Reminder?')]");
    private By cancelBtn = By.xpath("//button[contains(text(),'Cancel')]");
    private By clearMandateBtn = By.cssSelector(" div.css-1xc3v61-indicatorContainer");
    private By reportHeader = By.xpath("//span[contains(text(),'Fee Subscription - Reports')]");
    private By actionsReport = By.xpath("//div[contains(text(),'Actions')]");
    private By reloadBtn = By.cssSelector("div.px-2.py-2.cursor-pointer:nth-of-type(1)");
    private By downloadBtn = By.cssSelector("div.px-2.py-2.cursor-pointer:nth-of-type(2)");
    private By confirmPopup = By.xpath("//div[contains(text(),'Please try to download generated')]");


    public FeeSubscriptionPage(WebDriver driver){
        this.driver=driver;
        eleUtil =new ElementUtil(driver);
        jsUtil = new JavaScriptUtil(driver);
    }
    public String getPageUrl(){
        String Url= eleUtil.waitforURLContainsAndReturns(AppConstants.FEE_SUBSCRIPTION_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(Url);
        return Url;
    }
    public boolean isFeeSubscriptionHeaderExist(){
        eleUtil.waitforElementVisible(feeRegistrationHeader,AppConstants.DEFAULT_LONG_TIME_OUT);
        return eleUtil.isElementDisplayed(feeRegistrationHeader);
    }
    public boolean isSearchFieldExist(){
        eleUtil.waitforElementpresence(searchBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(searchBtn);
    }
    public void enterSearch(){
        eleUtil.waitforElementpresence(searchBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys("test nikhil");
    }
    public void doReset(){
        eleUtil.waitforElementpresence(resetBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
    }
    public boolean isMandateDropDownExist(){
        eleUtil.waitforElementpresence(mandateDropDown,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        return eleUtil.isElementDisplayed(mandateDropDown);
    }
    public void selectMandateDropDown(){
        eleUtil.selectDropDownText(mandateDropDown,"Pending");
    }
    public void clearMandate(){
        eleUtil.waitforElementpresence(clearMandateBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
    }
    public boolean isResetBtnExist(){
        eleUtil.waitforElementpresence(resetBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public int getColomnListHeaderCount(){
        eleUtil.waitforElementpresence(studentNameText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(actionsHeader);
        jsUtil.scrollToPageHorizontal();
        return  eleUtil.waitForElementsVisible(colomnsList,AppConstants.DEFAULT_LONG_TIME_OUT).size();
    }
    public List<String> getClomnListHeaderList(){
        List<WebElement> headerList= eleUtil.waitForElementsVisible(colomnsList,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List<String> headerListText = new ArrayList<String>();
        for(WebElement e : headerList){
            String headerText= e.getText();
            headerListText.add(headerText);
        }
        return headerListText;
    }
    public void moveToActionsBtn(){
        eleUtil.waitforElementpresence(checkBox, AppConstants.DEFAULT_LONG_TIME_OUT);
        eleUtil.waitforElementpresence(studentNameText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(actionsHeader);
        jsUtil.scrollToPageHorizontal();
        eleUtil.waitforElementpresence(messageBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT);

    }
    public boolean isMessageBtnExist(){
        moveToActionsBtn();
       return eleUtil.isElementDisplayed(messageBtn);
    }
    public boolean isEyeButtonExist(){
      moveToActionsBtn();
      return eleUtil.isElementEnabled(eyeButton);
    }
    public boolean checkRegistrationDetails(){
        moveToActionsBtn();
        eleUtil.waitforElementpresence(eyeButton,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.isElementEnabled(nachHeader);
        eleUtil.scrollToElement(backHeader);
        return eleUtil.isElementEnabled(pendingHeader);
    }
    public void closeModel(){
        eleUtil.waitforElementVisible(closeBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
    }
    public void doBack(){
        eleUtil.waitforElementpresence(backBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
    }
    public boolean getStudentActivity(){
        eleUtil.waitforElementpresence(hyperLink,AppConstants.DEFAULT_LONG_TIME_OUT).click();
        return eleUtil.isElementDisplayed(studentActivityHeader);
    }
    public void sendRegistrationBtnExist(){
        eleUtil.waitforElementpresence(checkBox,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.waitforElementpresence(linkBtn,AppConstants.DEFAULT_LONG_TIME_OUT).click();
        eleUtil.waitforElementpresence(reminderHeader,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.isElementDisplayed(reminderHeader);
        eleUtil.doClick(cancelBtn);
    }
    public void selectNameAndMandate(){
        doReset();
        clearMandate();
        enterSearch();
        selectMandateDropDown();
    }
    public boolean setReportPage(){
        eleUtil.waitforElementpresence(reportsBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.waitforElementpresence(reportHeader,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.waitforElementpresence(actionsReport,AppConstants.DEFAULT_LONG_TIME_OUT);
        eleUtil.waitforElementpresence(reloadBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.waitforElementpresence(confirmPopup,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        String textName =driver.findElement(confirmPopup).getText();
        System.out.println(textName);
        return eleUtil.isElementDisplayed(confirmPopup);

    }


}
