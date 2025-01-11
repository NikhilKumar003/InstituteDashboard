package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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
    @Test
    public void getFeeSummaryHeadersListTest(){
       List<String> headerTextList = summaryPage.getFeeSummaryHeadersList();
       Assert.assertEquals(headerTextList,AppConstants.EXPECTED_FEE_SUMMARY_HEADERS_LIST);
    }
    @Test
    public void getColumnHeaderListTest(){
        Assert.assertTrue(summaryPage.getCountOfHeadersList());
    }
    @Test(priority = Integer.MAX_VALUE-1)
    public void getSummaryHeadersViewTest(){
        summaryPage.getSummaryHeadersView();
    }
    @Test(priority = Integer.MAX_VALUE)
    public void isSubmitBtnExistTest(){
        Assert.assertTrue(summaryPage.isSubmitBtnExist());
    }
    @Test
    public void getTotalFeeTrendsText(){
        Assert.assertTrue(summaryPage.getTotalFeeTrends());
    }
    @Test
    public void getPaymentTimeGraph(){
        Assert.assertTrue(summaryPage.getPaymentTimeGraph());
    }
    @Test
    public void getPaymentTrendGraph(){
        Assert.assertTrue(summaryPage.getPaymentTrendGraph());
    }
    @Test
    public void isGraphExistTest(){
        Assert.assertTrue(summaryPage.isGraphExist());
    }

}
