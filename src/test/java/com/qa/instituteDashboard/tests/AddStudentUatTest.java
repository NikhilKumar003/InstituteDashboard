package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.pages.StudentListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddStudentUatTest extends BaseTest {
    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        addStudentPage= dashBoardPage.setAddStudentPage();
    }
    public String getMobileNumber(){
        long currentTime = System.currentTimeMillis();
        String timeInString= Long.toString(currentTime);
        String mobile= "62"+timeInString.substring(timeInString.length()-8);

        return mobile;
    }
    public void enterMobile(String mobile1){
        System.out.println("enter mobile Number"+ mobile1);

    }
    public String generatedNumber(){
        String generatedMobile = getMobileNumber();
        enterMobile(generatedMobile);
        return generatedMobile;
    }

    public String getStudentId(){
        long currentTime = System.currentTimeMillis();
        String timeInString= Long.toString(currentTime);
        String rollNumber= "GT "+ timeInString.substring(timeInString.length()-8);
        return rollNumber;
    }
    @Test()
    public void createStudentTest() {
        String txt =  addStudentPage.createNewStudent(prop.getProperty("instituteName"), prop.getProperty("branchName"),
                "Test Nikhil for Nach",getMobileNumber(),getStudentId(), prop.getProperty("courseName"), prop.getProperty("className"),
                "nikhil.kumar@leo1.in","Test Father",
                "8909123245","12-09-2000","9054653278", prop.getProperty("gender"));
        Assert.assertEquals(txt, AppConstants.ADD_STUDENT_HEADER);
//        studentListPage.setSearchBtn(getMobileNumber());
    }
    @Test(priority = Integer.MAX_VALUE)
    public void checkStudentDetailsTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashBoardPage.setFeePaymentBtn(),"Fee payment button isn't clickable");
        studentListPage = dashBoardPage.setStudentListBtn();
        softAssert.assertTrue(studentListPage.isSearchFieldExist());
//        studentListPage.setSearchBtn("8904564513");
        softAssert.assertTrue(studentListPage.setCapturePayBtn("8904564514"));
        softAssert.assertAll();

    }
}
