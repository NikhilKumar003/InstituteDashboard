package com.qa.instituteDashboard.tests;

import com.qa.instituteDashboard.base.BaseTest;
import com.qa.instituteDashboard.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddStudentPageTest extends BaseTest {
    @BeforeClass
    public void loginSetup(){
        dashBoardPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        addStudentPage= dashBoardPage.setAddStudentPage();
    }
    @Test
    public void getPageUrlTest(){
        String studentUrl = addStudentPage.getPageUrl();
        Assert.assertTrue(studentUrl.contains(AppConstants.ADD_STUDENT_PAGE_FRACTION_URL));
    }
    @Test
    public void isAddStudentHeaderExistTest(){
        Assert.assertTrue(addStudentPage.isAddStudentHeaderExist());
    }
    @Test
    public void isResetBtnExistTest() {
        Assert.assertTrue(addStudentPage.isResetBtnExist());
    }
    public String getMobileNumber(){
        long currentTime = System.currentTimeMillis();
         String timeInString= Long.toString(currentTime);
         String mobile= "67"+timeInString.substring(timeInString.length()-8);
         return mobile;
    }
    public String getStudentId(){
        long currentTime = System.currentTimeMillis();
        String timeInString= Long.toString(currentTime);
        String rollNumber= "GT "+ timeInString.substring(timeInString.length()-8);
        return rollNumber;
    }

    @Test(priority = Integer.MAX_VALUE)
    public void createStudentTest() {
        String txt =  addStudentPage.createNewStudent(prop.getProperty("instituteName"), prop.getProperty("branchName"),
                "Test Nikhil for Nach",getMobileNumber(),getStudentId(), prop.getProperty("courseName"), prop.getProperty("className"),
                "nikhil.kumar@leo1.in","Test Father",
                "8909123245","12-09-2000","9054653278", prop.getProperty("gender"));
        Assert.assertEquals(txt, AppConstants.ADD_STUDENT_HEADER);
//        studentListPage.setSearchBtn(getMobileNumber());
    }

}
