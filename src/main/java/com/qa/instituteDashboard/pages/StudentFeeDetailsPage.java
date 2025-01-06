package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.plaf.PanelUI;

public class StudentFeeDetailsPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By viewUpdateBtn =By.xpath("//button[text()='View/Update']");
    private By feeRemainderBtn =By.xpath("//button[text()='Send Reminder']");
    private By capturePaymentBtn =By.xpath("//button[text()='Capture Payment']");
    private By transactionBtn = By.xpath("//button[text()='View']");
    private By refundBtn =By.xpath("//button[text()='Refund']");
    private By waiverBtn =By.xpath("//button[text()='Waiver']");
    private By feesViewHeader = By.xpath("//span[text()='Fees View/Update']");
    private By addFeeEntryBtn = By.xpath("//span[text()='Fee Entry']");
    private By closeBtn = By.xpath("//img[@alt='close']");
    private By listOfInstallments = By.cssSelector("w-100 mt-2 ");
    private By makePaymentBtn = By.xpath("//button[contains(text(),'Make Payment')]");
    private By captureHeaderText = By.xpath("//span[contains(text(),'Capture payment')]");



    public StudentFeeDetailsPage(WebDriver driver){
        this.driver= driver;
        eleUtil = new ElementUtil(driver);
    }
    public String getPageUrl(){
        String Url =eleUtil.waitforURLContainsAndReturns(AppConstants.STUDENT_FEE_DETAILS_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Student fee details page title :"+Url );
        return Url;
    }
    public boolean isViewUpdateBtnExist(){
        eleUtil.waitforElementVisible(viewUpdateBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(viewUpdateBtn);
    }
    public boolean isFeeRemainderBtnExist(){
        eleUtil.waitforElementVisible(feeRemainderBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(feeRemainderBtn);
    }
    public boolean isCapturePaymentBtnExist(){
        eleUtil.waitforElementVisible(capturePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(capturePaymentBtn);
    }
    public boolean isRefundBtnExist(){
        eleUtil.waitforElementVisible(refundBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(refundBtn);
    }
    public boolean isWaiverBtnExist(){
        eleUtil.waitforElementVisible(waiverBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(waiverBtn);
    }
    public void setCloseBtn(){
        eleUtil.doClick(closeBtn);
    }
    public boolean isAddFeeEntryBtn(){
        eleUtil.waitforElementVisible(viewUpdateBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(feesViewHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(addFeeEntryBtn);
    }
    public boolean setCapturePaymentBtn(){

       eleUtil.waitforElementVisible(capturePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(capturePaymentBtn);
       eleUtil.waitforElementVisible(makePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
       return eleUtil.isElementDisplayed(makePaymentBtn);
    }


}
