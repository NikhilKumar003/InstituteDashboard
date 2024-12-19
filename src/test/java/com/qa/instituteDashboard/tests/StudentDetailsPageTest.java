package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class StudentDetailsPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashBoardPage.setFeePaymentBtn();
        studentListPage =dashBoardPage.setStudentListBtn();
    }
//    @BeforeMethod
//    public void studentListSetup(){
//        studentListPage =dashBoardPage.setStudentListBtn();
//    }
//    @Test
//    public void getStudentListPageTitleTest(){
//        String title= studentListPage.getPageTitle();
//        Assert.assertEquals(title, AppConstants.STUDENT_LIST_PAGE_TITLE);
//    }
    @Test
    public void getPageUrlTest(){
        String studentUrl = studentListPage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.STUDENT_LIST_PAGE_FRACTION_URL));
    }
    @Test
    public void isSearchFieldExistTest(){
        Assert.assertTrue(studentListPage.isSearchFieldExist());
    }
    @Test
    public void isResetBtnExistTest(){
        Assert.assertTrue(studentListPage.isResetBtnExist());
    }
    @Test
    public void isSendRemainderExistTest(){
        Assert.assertTrue(studentListPage.isSendRemainderExist());
    }
    @Test
    public void isCaptureBtnExistTest(){
        Assert.assertTrue(studentListPage.isCaptureBtnExist());
    }
    @Test
    public void isTrackBtnExistTest(){
        Assert.assertTrue(studentListPage.isTrackExist());
    }
    @Test
    public void isInstituteDashboardBtnExistTest(){
        Assert.assertTrue(studentListPage.isInstituteDropDownExist());
    }
    @Test
    public void getColumnCount(){
       int count = studentListPage.getColomnListHeaderCount();
       Assert.assertEquals(count,AppConstants.STUDENT_LIST_HEADERS_COUNT);
    }
    @Test
    public void getColumnHeaderList(){
       List<String> headerTextList = studentListPage.getColomnListHeaderList();
       Assert.assertEquals(headerTextList,AppConstants.EXPECTED_STUDENT_LIST_HEADERS_LIST );
    }

    @DataProvider
    public Object[][] getStudentData(){
        return new Object[][]{
                {"7842290549"},
                {"9958757622"},
                {"7730005660"},
                {"8341369495"},
        };
    }


    @Test(dataProvider = "getStudentData")
    public void searchStudentFieldTest(String phone) throws InterruptedException {
        studentListPage.setSearchBtn(phone);
        Assert.assertTrue(studentListPage.isSendRemainderExist());
        studentListPage.doClear();
    }

}
