package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FeeSubscriptionTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeeSubscriptionBtn();
        feeSubscriptionPage=  dashBoardPage.setFeeRegistrationPage();
    }
    @Test
    public void getPageUrlTest(){
       String subscriptionUrl = feeSubscriptionPage.getPageUrl();
       Assert.assertTrue(subscriptionUrl.contains(AppConstants.FEE_SUBSCRIPTION_FRACTION_URL));
    }
    @Test(priority = Integer.MAX_VALUE)
    public void isRegistrationHeaderExistTest(){
        Assert.assertTrue(feeSubscriptionPage.isFeeSubscriptionHeaderExist());
    }
    @Test
    public void isSearchFieldExistTest(){
        Assert.assertTrue(feeSubscriptionPage.isSearchFieldExist());
    }
    @Test
    public void isMandateDropDownExistTest(){
        Assert.assertTrue(feeSubscriptionPage.isMandateDropDownExist());
    }


}
