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
    private By transactionHeader = By.xpath("//span[text()='Transactions']");
    private By downloadBtn = By.cssSelector("div.mr-2 > span > img");
    private By transactionTable = By.cssSelector("div.w-100 table");
    private By refundHeader = By.xpath("//span[text()='Student Refund']");
    private By applyRefundBtn = By.xpath("//button[text()='Apply Refund']");
    private By waiverHeader = By.xpath("//span[text()='Student Waiver']");
    private By applyWaiverBtn = By.xpath("//button[text()='Apply Waiver']");
    private By waiverTable = By.cssSelector("table.fee-structure-table-v2_table__gVrp4");
    private By addFeeEntryHeader = By.xpath("//span[text()='Add New Fee Entry']");
    private By dateField = By.xpath("//input[@placeholder='Fee Due Date']");
    private By amountfield = By.xpath("//input[@placeholder='Enter Fee Amount']");
    private By selectFeeType = By.cssSelector(" div.css-19bb58m");
    private By feeDescriptionField = By.xpath("//input[@placeholder='Enter Fee Description']");
    private By addNewFeeBtn = By.xpath("//button[text()='Add New Fees']");



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
    public boolean setTransactionTable(){
        eleUtil.waitforElementVisible(transactionBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(transactionBtn);
        eleUtil.waitforElementVisible(transactionHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.doClick(downloadBtn);
        return eleUtil.isElementDisplayed(transactionTable);
    }
    public boolean setRefundBtn(){
        eleUtil.waitforElementVisible(refundBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(refundBtn);
        eleUtil.waitforElementVisible(refundHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.doClick(applyRefundBtn);
        return eleUtil.isElementDisplayed(applyRefundBtn);
    }
    public boolean setWaiverBtn(){
        eleUtil.waitforElementVisible(waiverBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.scrollToElement(waiverBtn);
        eleUtil.waitforElementVisible(waiverHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.doClick(applyWaiverBtn);
        return eleUtil.isElementDisplayed(applyWaiverBtn);
    }
    public void setAddNewFeeEntry(){
        eleUtil.waitforElementVisible(viewUpdateBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(addFeeEntryBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(addFeeEntryHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);



    }


}
