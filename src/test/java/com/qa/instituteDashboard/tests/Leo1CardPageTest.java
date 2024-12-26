package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.pages.DashBoardPage;
import com.qa.instituteDashboard.pages.Leo1CardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Leo1CardPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
       dashBoardPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        leo1CardPage= dashBoardPage.setCardDashboardPage();
    }

    @Test
    public void getPageUrlTest(){
        String cardUrl= leo1CardPage.getPageUrl();
        Assert.assertTrue(cardUrl.contains(AppConstants.LEO1_CARD_PAGE_FRACTION_URL));
    }
    @Test
    public void isDownloadTemplateBtnExistTest() {
        Assert.assertTrue(leo1CardPage.isDownloadTemplateBtn());
    }
    @Test
    public void isUploadExcelBtnExistTest(){
        Assert.assertTrue(leo1CardPage.isUploadExcelBtn());
    }
    @Test
    public void isDownloadTableBtnExistTest(){
        Assert.assertTrue(leo1CardPage.isdownloadTableBtn());
    }
    @Test
    public void isResetBtnExistTest(){
        Assert.assertTrue(leo1CardPage.isResetBtn());
    }
    @Test
    public void isSubmitBtnExistTest(){
        Assert.assertTrue(leo1CardPage.isSubmitAndClearBtn());
    }
    @Test
    public void checkUserWithMobileTest(){
        leo1CardPage.checkUserWithMobile();
    }
    @Test
    public void verifyAllUsersLoadedTest(){
        leo1CardPage.verifyAllUsersLoaded();
    }

}
