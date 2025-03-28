package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeeStructurePage  {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By feeStructureHeader = By.xpath("//div[text()='Fee Structure']");
    private By courseBtn = By.xpath("//span[text()='Course']");
    private By classBtn = By.xpath("//span[text()='Class/Fee Entry']");
    private By instituteDD = By.xpath("//div[@class=' css-19bb58m']");
    private By branchDD = By.xpath("(//div[@class=' css-19bb58m'])[2]");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By downloadBtn = By.xpath("//span[text()='Download All']");
    private By addCourseHeader = By.xpath("//span[text()='Add New Course']");
    private By courseDropDown = By.cssSelector("div.col-md-7 div.css-yi2ntm-control");
    private By classDropDown = By.cssSelector("div.css-yi2ntm-control div[id^='react-select']");
    private By enterCourseText = By.xpath("//input[@placeholder='Enter Course Name']");
    private By enterAliasCourseText = By.xpath("//input[@placeholder='Enter Alias Course Name']");
    private By classNoText = By.xpath("//input[@type='number']");
    private By nextBtn = By.xpath("(//img[@decoding='async'])[10]");
    private By addCourseBtn =By.xpath("//button[text()='Add New Course']");
    private By addNewClassHeader = By.xpath("//span[contains(text(),'Add New Class/')]");
    private By saveBtn = By.xpath("//button[contains(text(),'Save Details')]");
    private By closeBtn = By.xpath("//img[@alt='close']");
    private By branchDropDown = By.xpath("(//div[contains(@class, 'css-1dimb5e-singleValue')])[last()]");
    private By totalStudentText = By.xpath("(//div[contains(@class,'text-right')])");
    private By courseText = By.xpath("//div[text()='No.of Classes/Years:']");
    private By branchText = By.xpath("(//div[contains(text(),'Branch:')])");





    public FeeStructurePage(WebDriver driver) {
        this.driver =driver;
        eleUtil = new ElementUtil(driver);
     }
    public String getPageTitle(){
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.FEE_STRUCTURE_PAGE_TITLE,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Fee Structure Page title :"+ title);
        return title;
    }
    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.FEE_STRUCTURE_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Dashboard Page Url :" + url);
        return url;
    }
    public boolean isFeeStructureHeaderExist(){
        return  eleUtil.isElementDisplayed(feeStructureHeader);
    }
    public boolean isInstituteDDExist(){
        return  eleUtil.isElementDisplayed(instituteDD);
    }
    public boolean isBranchDDExist(){
        return  eleUtil.isElementDisplayed(branchDD);
    }
    public boolean isCourseBtnExist(){
        return  eleUtil.isElementDisplayed(courseBtn);
    }
    public boolean isClassBtnExist(){
        return  eleUtil.isElementDisplayed(classBtn);
    }
    public boolean isDownloadBtnExist(){
        return  eleUtil.isElementDisplayed(downloadBtn);
    }
    public boolean isResetBtnExist(){
        return  eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean addCourseBtn(){
        eleUtil.waitforElementpresence(courseBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.waitforElementVisible(addCourseHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.waitforElementpresence(branchText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.selectDropDownText(classDropDown,"MUMBAI");
        eleUtil.waitforElementVisible(enterCourseText,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys("test-1");
        eleUtil.waitforElementpresence(enterAliasCourseText,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys("test");
        eleUtil.waitforElementpresence(classNoText,AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys("2");
        eleUtil.waitforElementpresence(courseText,AppConstants.DEFAULT_MEDIUM_TIME_OUT);

        eleUtil.waitforElementpresence(nextBtn,AppConstants.DEFAULT_LONG_TIME_OUT).click();
        eleUtil.waitforElementpresence(addCourseBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
       return  eleUtil.isElementDisplayed(addCourseBtn);
    }
    public boolean addclassBtn(){
        eleUtil.waitforElementpresence(classBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementpresence(addNewClassHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(saveBtn);
    }
    public void setCloseBtn(){
        eleUtil.doClick(closeBtn);
    }
    public boolean selectBranch(){
        eleUtil.waitforElementpresence(instituteDD,AppConstants.DEFAULT_SHORT_TIME_OUT);
        eleUtil.selectDropDownText(branchDD, "MUMBAI");
        eleUtil.scrollToElement(totalStudentText);
        return eleUtil.isElementDisplayed(totalStudentText);

    }


}
