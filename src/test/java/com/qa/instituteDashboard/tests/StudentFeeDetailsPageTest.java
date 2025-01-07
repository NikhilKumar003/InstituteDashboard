package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentFeeDetailsPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup() throws InterruptedException {
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        studentListPage= dashBoardPage.setStudentListBtn();
        studentFeeDetailsPage= studentListPage.setStudentFeeDetailsPage("7842290549");
    }
//    @BeforeMethod
//    public void studentFeeDetailsSetup(){
//
//    }
    @Test
    public void getPageUrlTest(){
        String studentDetailsUrl = studentFeeDetailsPage.getPageUrl();
        Assert.assertTrue(studentDetailsUrl.contains(AppConstants.STUDENT_FEE_DETAILS_PAGE_FRACTION_URL));
    }
    @Test
    public void isViewUpdateBtnExistTest(){
     Assert.assertTrue(studentFeeDetailsPage.isViewUpdateBtnExist());
    }
    @Test
    public void isFeeRemianderBtnExistTest(){
        Assert.assertTrue(studentFeeDetailsPage.isFeeRemainderBtnExist());
    }
    @Test
    public void isCapturePaymentBtnExistTest(){
        Assert.assertTrue(studentFeeDetailsPage.isCapturePaymentBtnExist());
    }
    @Test
    public void isRefundBtnExistTest(){
        Assert.assertTrue(studentFeeDetailsPage.isRefundBtnExist());
    }
    @Test
    public void isWaiverBtnExistTest(){
        Assert.assertTrue(studentFeeDetailsPage.isWaiverBtnExist());
    }
    @Test(priority = Integer.MAX_VALUE-1)
    public void isAddFeeEntryBtnExistTest(){
        Assert.assertTrue(studentFeeDetailsPage.isAddFeeEntryBtn());
        studentListPage.setCloseBtn();
    }
    @Test(priority = Integer.MAX_VALUE)
    public void setCapturePaymentBtnTest(){
        Assert.assertTrue(studentFeeDetailsPage.setCapturePaymentBtn());
        studentListPage.setCloseBtn();
    }
    @Test
    public void setTransactionTableTest(){
        Assert.assertTrue(studentFeeDetailsPage.setTransactionTable());
        studentFeeDetailsPage.setCloseBtn();
    }
    @Test
    public void setRefundTest(){
        Assert.assertTrue(studentFeeDetailsPage.setRefundBtn());
        studentFeeDetailsPage.setCloseBtn();
    }
    @Test
    public void setWaiverTest(){
        Assert.assertTrue(studentFeeDetailsPage.setWaiverBtn());
        studentFeeDetailsPage.setCloseBtn();
    }
    @Test
    public void setAddNewFeeEntryTest(){
     studentFeeDetailsPage.setAddNewFeeEntry();
    }


}
