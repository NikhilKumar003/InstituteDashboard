package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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


}
