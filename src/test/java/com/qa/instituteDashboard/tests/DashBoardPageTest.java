package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.pages.StudentListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class DashBoardPageTest extends BaseTest {

    @BeforeClass
    public void dashboardSetup(){
    dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void getDashboardPageTitleTest(){
        String title= dashBoardPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
    }
    @Test
    public void getDashboardPageUrlTest(){
        String pageUrl = dashBoardPage.getPageUrl();
        Assert.assertTrue(pageUrl.contains(AppConstants.DASHBOARD_PAGE_FRACTION_URL));
    }
    @Test
    public void isWelcomeHeaderExistTest(){
      Assert.assertTrue(dashBoardPage.isWelcomeHeaderExist());
    }
    @Test
    public void getHeaderCountTest(){
       int count= dashBoardPage.getHeadersCount();
        Assert.assertEquals(count,AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
    }
    @Test
    public void getHeaderListTest(){
        List<String> expectedHeaders= dashBoardPage.getHeadersList();
        Assert.assertEquals(expectedHeaders, AppConstants.EXPECTED_DASHBOARD_HEADERS_LIST);
    }
    @Test
    public void isResetPwdBtnExistTest(){
        Assert.assertTrue(dashBoardPage.isResetPasswordExist());
    }
    @Test
    public void isChangeRegistrationExistTest(){
        Assert.assertTrue(dashBoardPage.isChangeRegistrationExist());
    }
    @Test
    public void isAccountLogoExistTest(){
        Assert.assertTrue(dashBoardPage.isAccountExist());
    }
    @Test
    public void isNavBarExistTest(){
        Assert.assertTrue(dashBoardPage.isNavBarExist());
    }
     @Test
    public void getNavBarTest(){
        dashBoardPage.setNavBar();
       Assert.assertTrue(dashBoardPage.isFeePaymentExist());
    }
    @Test(priority = Integer.MAX_VALUE-2)
    public void feePaymentBtnTest(){
        Assert.assertTrue(dashBoardPage.setFeePaymentBtn());
    }
    @Test(priority = Integer.MAX_VALUE-1)
    public void feePaymentListTest(){
//        dashBoardPage.setFeePaymentBtn();
       List<String> paymentList= dashBoardPage.getFeePaymentList();
       Assert.assertEquals(paymentList,AppConstants.EXPECTED_FEEPAYMENT_HEADERS_LIST);
    }
    @Test(priority = Integer.MAX_VALUE)
    public void studentListPageTest() {
//        dashBoardPage.setFeePaymentBtn();
        studentListPage = dashBoardPage.setStudentListBtn();
        String studentUrl =studentListPage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.STUDENT_LIST_PAGE_FRACTION_URL));
    }

}
