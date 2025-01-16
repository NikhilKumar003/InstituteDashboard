package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FeeStructurePageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        feeStructurePage= dashBoardPage.setFeeStructurePage();
    }
    @Test
    public void getPageUrlTest(){
        String studentUrl = feeStructurePage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.FEE_STRUCTURE_PAGE_FRACTION_URL));
    }
    @Test
    public void isFeeStructureHeaderExistTest(){
        Assert.assertTrue(feeStructurePage.isFeeStructureHeaderExist());
    }
    @Test
    public void isResetBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isResetBtnExist());
    }
    @Test
    public void isInstituteBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isInstituteDDExist());
    }
    @Test
    public void isBranchBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isBranchDDExist());
    }
    @Test
    public void isCourseBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isCourseBtnExist());
    }
    @Test
    public void isClassBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isClassBtnExist());
    }
    @Test
    public void isDownloadBtnExistTest() {
        Assert.assertTrue(feeStructurePage.isDownloadBtnExist());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void addCourseBtnTest(){
        Assert.assertTrue(feeStructurePage.addCourseBtn());
    }
    @Test(priority = Integer.MAX_VALUE-1)
    public void addClassBtnTest(){
        Assert.assertTrue(feeStructurePage.addclassBtn());
        feeStructurePage.setCloseBtn();
    }
}
