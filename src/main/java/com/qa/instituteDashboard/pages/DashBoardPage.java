package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashBoardPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By addStudentBtn= By.xpath("//span[contains(text(),'Add Student')]");
    private By summaryBtn= By.xpath("//span[contains(text(),'Summary')]");
    private By feePaymentBtn= By.xpath("//span[contains(text(),'Fee Payment')]");
    private By feeStructureBtn= By.xpath("//span[contains(text(),'Fee Structure')]");
    private By bulkActionBtn= By.xpath("//span[contains(text(),'Bulk Action')]");
    private By studentListBtn= By.xpath("//span[contains(text(),'Student List')]");
    private By allApplicationBtn= By.xpath("//span[contains(text(),'All Applications')]");
    private By loanApplicationBtn= By.xpath("//span[contains(text(),'Loan Applications')]");
    private By coinRequestBtn= By.xpath("//span[contains(text(),'Coins Request')]");
    private By accounttBtn= By.cssSelector("img[alt='avatar']");
    private By signOutBtn= By.cssSelector("div.ml-2");
    private By myProfileBtn= By.cssSelector("span.ml-2.flex-grow-1");
    private By changeRegistrationBtn= By.xpath("//a[.='Change Registered Ph.']");
    private By resetStudentPasswordBtn= By.xpath("//a[.='Reset student password']");
    private By feeReiubursmentBtn= By.xpath("//span[text()='Fee Reimbursement']");
    private By createApplicationBtn= By.xpath("//span[text()='Create application']");
    private By welcomeText= By.cssSelector("#MainScrollbar h2");
    private By sideHeaders= By.cssSelector("#containerSidebar .ps-menu-root span.Sidebar_MenuActiveItemText__6_E5Q");
    private By navBar= By.xpath("//img[@alt='toggle menu']");
    private By resetBtn = By.xpath("//span[text()='Reset']");
    private By feePaymentList= By.xpath("//*[@id='containerSidebar']/nav/ul/div[3]/ul/li");
    private By leo1CardBtn= By.xpath("//span[contains(text(),'Leo1 Card')]");
    private By preIssuanceBtn= By.xpath("//span[contains(text(),'Pre-Issuance')]");
    private By cardDashboardBtn= By.xpath("(//span[contains(text(),'Dashboard')])[2]");
    private By fileManagerBtn = By.xpath("//span[contains(text(),'File Manager')]");




    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        eleUtil = new ElementUtil(driver);
     }

    public String getPageTitle(){
        String title = eleUtil.waitforTitleContainsAndReturns(AppConstants.HOME_PAGE_TITLE,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Home Page title :"+ title);
        return title;
    }
    public String getPageUrl(){
        String url= eleUtil.waitforURLContainsAndReturns(AppConstants.DASHBOARD_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Dashboard Page Url :" + url);
        return url;
    }

    public boolean isWelcomeHeaderExist(){
       return  eleUtil.isElementDisplayed(welcomeText);
    }
    public int getHeadersCount(){
       List<WebElement> headers= eleUtil.waitForElementsVisible(sideHeaders,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println(headers.size());
       return headers.size();
    }
    public List<String> getHeadersList(){
        List<WebElement> headers= eleUtil.waitForElementsVisible(sideHeaders,AppConstants.DEFAULT_SHORT_TIME_OUT);
        List<String> headerList = new ArrayList<String>();
        for(WebElement e: headers){
            String headersText = e.getText();
            headerList.add(headersText);
//            System.out.println(headersText);
        }
        return headerList;
    }
    public boolean isCreateApplicationExist(){
       return eleUtil.isElementDisplayed(createApplicationBtn);
    }
    public boolean isResetPasswordExist(){
        return eleUtil.isElementDisplayed(resetStudentPasswordBtn);
    }
    public boolean isChangeRegistrationExist(){
        return eleUtil.isElementDisplayed(changeRegistrationBtn);
    }
    public boolean isAccountExist(){
        return eleUtil.isElementDisplayed(accounttBtn);
    }
    public boolean isNavBarExist(){
        return eleUtil.isElementDisplayed(navBar);
    }
    public void setNavBar(){
        eleUtil.doClick(navBar);
        eleUtil.doClick(navBar);
        eleUtil.waitforElementVisible(feePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
    }
    public boolean isFeePaymentExist(){
        return eleUtil.isElementDisplayed(feePaymentBtn);
    }
    public boolean isResetBtnExist(){
        return eleUtil.isElementDisplayed(resetBtn);
    }
    public boolean setFeePaymentBtn(){
        eleUtil.waitforElementVisible(feePaymentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return eleUtil.isElementDisplayed(studentListBtn);

    }
    public boolean setLoanAppBtn(){
        eleUtil.waitforElementVisible(loanApplicationBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return eleUtil.isElementDisplayed(allApplicationBtn);

    }
    public List<String> getFeePaymentList(){
//        setFeePaymentBtn();
        List<WebElement> feePaymentHeaderList=  eleUtil.waitForElementsVisible(feePaymentList, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List<String> headerLists = new ArrayList<String>();
        for(WebElement e: feePaymentHeaderList){
            String headerText= e.getText();
            headerLists.add(headerText);
        }
        return headerLists;
}
    public StudentListPage setStudentListBtn(){
      eleUtil.waitforElementVisible(studentListBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
      return new  StudentListPage(driver);
    }
    public LoanApplicationPage setAllLoansPage(){
//        eleUtil.waitforElementVisible(loanApplicationBtn, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(allApplicationBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  LoanApplicationPage(driver);
    }
    public AddStudentPage setAddStudentPage(){
        eleUtil.waitforElementVisible(addStudentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  AddStudentPage(driver);
    }
    public FeeStructurePage setFeeStructurePage(){
        eleUtil.waitforElementVisible(feeStructureBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  FeeStructurePage(driver);
    }
    public BulkActionPage setBulkActionsPage(){
        eleUtil.waitforElementVisible(bulkActionBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  BulkActionPage(driver);
    }
    public CoinsRequestPage setCoinsRequestPage(){
        eleUtil.waitforElementVisible(coinRequestBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  CoinsRequestPage(driver);
    }
    public BulkActionPage setFeeReimbursementPage(){
        eleUtil.waitforElementVisible(feeReiubursmentBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  BulkActionPage(driver);
    }
    public SummaryPage setSummaryPage(){
        eleUtil.waitforElementVisible(summaryBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new  SummaryPage(driver);
    }
    public Leo1CardPage setCardDashboardPage(){
        eleUtil.waitforElementVisible(leo1CardBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(preIssuanceBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.doClick(cardDashboardBtn);
        return new Leo1CardPage(driver);
    }
    public FileManagerPage setFileManagerPage(){
        eleUtil.waitforElementVisible(fileManagerBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        return new FileManagerPage(driver);
    }
}
