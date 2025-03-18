package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
    @Test
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
    @Test
    public void isResetBtnExistTest(){
        Assert.assertTrue(feeSubscriptionPage.isResetBtnExist());
    }
    @Test(priority = Integer.MAX_VALUE-3)
    public void getColomnCount(){
        int count =feeSubscriptionPage.getColomnListHeaderCount();
        Assert.assertEquals(count,AppConstants.FEE_SUBSCRIPTION_LIST_HEADER_COUNT);
    }
    @Test(priority = Integer.MAX_VALUE-2,enabled = false)
    public void getColomnHeaderList(){
        List<String> headerListText= feeSubscriptionPage.getClomnListHeaderList();
        Assert.assertEquals(headerListText,AppConstants.EXPECTED_STUDENT_LIST_HEADERS_LIST);
    }
    @Test(priority = Integer.MAX_VALUE-1 )
    public void isMessageBtnExistTest(){
        SoftAssert softAssert = new SoftAssert();
        feeSubscriptionPage.enterSearch();
        feeSubscriptionPage.selectMandateDropDown();
//        softAssert.assertTrue(feeSubscriptionPage.isMessageBtnExist());
        softAssert.assertTrue(feeSubscriptionPage.isEyeButtonExist());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void checkRegistrationUserTest(){
        feeSubscriptionPage.selectNameAndMandate();
        Assert.assertTrue(feeSubscriptionPage.checkRegistrationDetails());
        feeSubscriptionPage.closeModel();
     }
    @Test(priority = Integer.MAX_VALUE)
    public void getStudentActivityTest(){
        feeSubscriptionPage.selectNameAndMandate();
        Assert.assertTrue(feeSubscriptionPage.getStudentActivity());
        feeSubscriptionPage.doBack();
    }
    @Test(priority = Integer.MAX_VALUE)
    public void sendRegistrationTest(){
        feeSubscriptionPage.selectNameAndMandate();
        feeSubscriptionPage.sendRegistrationBtnExist();
    }
    @Test(priority = Integer.MAX_VALUE)
    public void setReportPageTest(){
       Assert.assertTrue(feeSubscriptionPage.setReportPage());
    }


}
