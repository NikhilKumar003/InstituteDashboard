package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BulkActionsPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        bulkActionPage= dashBoardPage.setBulkActionsPage();
    }
    @Test
    public void getPageUrlTest(){
        String studentUrl = bulkActionPage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.BULK_ACTIONS_PAGE_FRACTION_URL));
    }
    @Test
    public void isBulkCaptureHeaderExistTest(){
        Assert.assertTrue(bulkActionPage.isBulkCaptureHeaderExist());
    }
    @Test
    public void isBulkFeeBtnExistTest(){
        Assert.assertTrue(bulkActionPage.isBulkFeeBtnHeaderExist());
    }
    @Test
    public void isCapturePayBtnExistTest() {
        Assert.assertTrue(bulkActionPage.isCapturePayBtnExist());
    }
    @Test(priority = Integer.MAX_VALUE-1)
    public void isSampleDownloadBtnExistTest() {
        Assert.assertTrue(bulkActionPage.isSampleDownloadBtnExist());
        bulkActionPage.closeModel();
    }
    @Test(priority = Integer.MAX_VALUE)
    public void isUploadBtnExistTest() {
        Assert.assertTrue(bulkActionPage.isUploadFileDownloadBtnExist());
        bulkActionPage.closeModel();
    }
}
