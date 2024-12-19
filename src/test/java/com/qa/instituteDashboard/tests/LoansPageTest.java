package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoansPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setLoanAppBtn();
        loansPage =dashBoardPage.setAllLoansPage();
    }
    @Test
    public void getPageUrlTest(){
        String studentUrl = loansPage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.LOANS_PAGE_FRACTION_URL));
    }
    @Test
    public void isSearchFieldExistTest(){
        Assert.assertTrue(loansPage.isSearchFieldExist());
    }
    @Test
    public void isResetBtnExistTest(){
        Assert.assertTrue(loansPage.isResetBtnExist());
    }
    @Test
    public void isLoanHeaderExistTest(){
        Assert.assertTrue(loansPage.isAllLoansHeaderExist());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void getSearchFieldTest(){
        String mobile= loansPage.getSearchField(prop.getProperty("mobileNo"));
        Assert.assertEquals(mobile,AppConstants.STUDENT_MOBILE_NO);
    }
    @Test
    public void getLoanStatusTest(){
        String loan= loansPage.getLoanStatus(prop.getProperty("loanStatus"));
        Assert.assertEquals(loan,AppConstants.LOAN_STATUS );
    }
}
