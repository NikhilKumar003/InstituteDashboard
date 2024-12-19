package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest(){
        String actTitle= loginPage.getPageTitle();
        Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageUrlTest(){
        String actTitle= loginPage.getPageURL();
        Assert.assertTrue(actTitle.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
    }
    @Test
    public void forgotPasswordLinkTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    @Test
    public void LogoExistTest() {
        Assert.assertTrue(loginPage.isLogoExist());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void loginTest() {
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(dashBoardPage.getPageTitle(), AppConstants.HOME_PAGE_TITLE);
//           String homePageTitle=  loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
//            Assert.assertEquals(homePageTitle, AppConstants.HOME_PAGE_TITLE);

    }

}
