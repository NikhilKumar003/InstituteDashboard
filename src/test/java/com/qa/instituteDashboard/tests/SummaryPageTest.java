package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SummaryPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        summaryPage= dashBoardPage.setSummaryPage();
    }
    @Test
    public void getPageUrlTest(){
        String summaryUrl = summaryPage.getPageUrl();
        Assert.assertTrue(summaryUrl.contains(AppConstants.SUMMARY_PAGE_FRACTION_URL));
    }
    @Test
    public void isSummaryHeaderExist(){
        Assert.assertTrue(summaryPage.isFeeSummaryHeaderExist());
    }

}
