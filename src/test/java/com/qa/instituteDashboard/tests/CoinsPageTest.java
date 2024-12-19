package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CoinsPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        coinsRequestPage= dashBoardPage.setCoinsRequestPage();
    }
    @Test
    public void getCoinPageTitleTest(){
        String title= coinsRequestPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.COINS_PAGE_TITLE);
    }
    @Test
    public void getCoinPageUrlTest(){
        String pageUrl = coinsRequestPage.getPageUrl();
        Assert.assertTrue(pageUrl.contains(AppConstants.COINS_PAGE_FRACTION_URL));
    }
    @Test
    public void isCoinHeaderExistTest(){
        Assert.assertTrue(coinsRequestPage.isCoinHeaderExist());
    }
    @Test
    public void isDownloadSampleBtnExistTest(){
        Assert.assertTrue(coinsRequestPage.isDownloadSampleBtnExist());
    }
    @Test
    public void isUploadBulkBtnExistTest(){
        Assert.assertTrue(coinsRequestPage.isUploadBulkBtnExist());
    }
    @Test
    public void isDownloadPendingBtnExistTest(){
        Assert.assertTrue(coinsRequestPage.isDownloadPendingBtnExist());
    }
}
