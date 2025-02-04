package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import com.qa.instituteDashboard.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStudentPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;

    private By addStudentHeader = By.xpath("//h2[text()='Add Student']");
    private By instiuteDD = By.xpath("//div[contains(@class, ' css-19bb58m')]");
    private By branchDD = By.xpath("(//div[@class= ' css-19bb58m'])[2]");
    private By studentName = By.xpath("//input[@placeholder='Student Name']");
    private By stMobileNumber = By.xpath("//input[@placeholder='Student Mobile Number']");
    private By studentId = By.xpath("//input[@placeholder='Student Id']");
    private By selectCourseDD = By.xpath("//div[contains(@class, ' css-yi2ntm-control')]");
//    private By selectCourse = By.xpath("//div[text()='FEE SLAB JECRC']");
    private By selectClassDD = By.cssSelector("#react-select-5-placeholder");
//    private By selectClass = By.xpath("//h2[text()='Add Student']");
    private By emailId = By.cssSelector("input[placeholder='Email Id']");
    private By parentName = By.cssSelector("input[placeholder='Parent Name']");
    private By parentNumber= By.cssSelector("input[placeholder='Parent Mobile Number']");
    private By NextBtn = By.xpath("//button[text()='Next']");
    private By minKycId = By.xpath("//input[@placeholder='Min Kyc Id']");
    private By stDOB = By.cssSelector("input[placeholder='Student Dob']");
    private By submitBtn = By.xpath("//button[text()='Submit']");
    private By optionalText = By.xpath("//h3[text()='Optional Fields']");
    private By resetBtn = By.cssSelector("button.PrimaryButton_button__tfJh7.pl-4.pr-4.d-flex.align-items-center");
    private By alternateMobile = By.xpath("//input[@placeholder='Alternate Mobile Number']");
    private By genderSelect = By.cssSelector("div.css-hlgwow div.css-1jqq78o-placeholder");


    public AddStudentPage(WebDriver driver) {
        this.driver=driver;
        eleUtil = new ElementUtil(driver);
        jsUtil = new JavaScriptUtil(driver);
    }
    public String getPageUrl(){
        String Url=  eleUtil.waitforURLContainsAndReturns(AppConstants.ADD_STUDENT_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(Url);
        return Url;
    }
    public boolean isAddStudentHeaderExist(){
        eleUtil.waitforElementpresence(addStudentHeader, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(addStudentHeader);
    }
    public boolean isResetBtnExist(){
        eleUtil.waitforElementVisible(resetBtn, AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public String createNewStudent(String institute,String branch,String stName,String mobile, String stId,String course, String clsName,String mail, String parent, String parMobile,String dob, String altMobile,String gender){
        eleUtil.waitforElementVisible(instiuteDD,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.selectDropDownText(instiuteDD, institute);
        eleUtil.selectDropDownText(branchDD, branch);
        jsUtil.scrollIntoView(driver.findElement(emailId));
        eleUtil.scrollToElement(NextBtn);
        eleUtil.waitforElementVisible(studentName,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(stName);
        eleUtil.doSendKeys(stMobileNumber,mobile);
        eleUtil.doSendKeys(studentId,stId);
        eleUtil.selectDropDownText(selectCourseDD,course);
        eleUtil.waitforElementVisible(selectClassDD,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.selectDropDownText(selectClassDD,clsName);
        eleUtil.waitforElementVisible(emailId,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.doSendKeys(emailId,mail);
        eleUtil.doSendKeys(parentName,"Test Father");
        eleUtil.doSendKeys(parentNumber, "8943433267");
        eleUtil.doClick(NextBtn);
        eleUtil.waitForElementsVisible(optionalText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.doSendKeys(stDOB,dob);
        eleUtil.selectDropDownText(genderSelect, gender);
        eleUtil.doSendKeys(alternateMobile,altMobile);
        eleUtil.doClick(submitBtn);
        String text=  eleUtil.waitforElementVisible(addStudentHeader,AppConstants.DEFAULT_LONG_TIME_OUT).getText();
        return text;


    }

}
