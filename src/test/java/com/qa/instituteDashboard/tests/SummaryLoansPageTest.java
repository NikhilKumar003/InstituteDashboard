package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SummaryLoansPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        summaryLoansPage = dashBoardPage.setLoanSummaryPage();
    }
    @Test
    public void getPageUrlTest(){
        String Url = summaryLoansPage.getPageUrl();
        Assert.assertTrue(Url.contains(AppConstants.LOAN_SUMMARY_PAGE_FRACTION_URL));
    }
    @Test
    public void isCreateApplicationExistTest(){
        Assert.assertTrue(summaryLoansPage.isCreateApplicationExist());
    }
    @Test
    public void isResetBtnExistTest(){
        Assert.assertTrue(summaryLoansPage.isResetBtnExist());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void setCreateApplicationBtnTest(){
        Assert.assertTrue(summaryLoansPage.setCreateApplicationBtn());
    }
    @Test
    public void isLoanSummaryHeaderExistTest(){
        Assert.assertTrue(summaryLoansPage.isLoanSummaryHeaderExist());
    }

}
