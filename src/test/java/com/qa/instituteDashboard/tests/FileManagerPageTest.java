package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.pages.DashBoardPage;
import com.qa.instituteDashboard.pages.FileManagerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileManagerPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
     fileManagerPage= dashBoardPage.setFileManagerPage();
    }

    @Test
    public void getPageUrlTest(){
        String fileManagerUrl= fileManagerPage.getPageUrl();
        Assert.assertTrue(fileManagerUrl.contains(AppConstants.FILE_MANAGER_PAGE_FRACTION_URL));
    }
    @Test
    public void isFileManagerHeaderExistTest(){
      Assert.assertTrue(fileManagerPage.isFileManagerHeaderExist());
    }

    @Test
    public void isFetchMoreBtnExistTest(){
        Assert.assertTrue(fileManagerPage.isFetchMoreBtnExist());
    }
    @Test
    public void getColumnCount(){
        int count = fileManagerPage.getcolomnListHeaderCount();
        Assert.assertEquals(count,AppConstants.FEE_MANAGER_LIST_HEADERS_COUNT);
    }
}
