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
    private By feeRemainderBtn =By.xpath("//button[text()='View/Update']");
    private By capturePaymentBtn =By.xpath("//button[text()='View/Update']");
    private By refundBtn =By.xpath("//button[text()='View/Update']");
    private By waiverBtn =By.xpath("//button[text()='View/Update']");

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


}
