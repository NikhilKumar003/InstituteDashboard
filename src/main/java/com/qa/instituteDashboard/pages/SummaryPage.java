package com.qa.instituteDashboard.pages;

import com.qa.instituteDashboard.constants.AppConstants;
import com.qa.instituteDashboard.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SummaryPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By feeSummaryOverAllHeader = By.xpath("//h1[text()='Fee Summary - Overall']");
    private By feeSummaryInstituteHeader = By.xpath("//h1[text()='Fee Summary ']");
    private By feeSummaryHeaders = By.xpath("//h1[contains(text(),'Fee Summary')]");
    private By feeSummaryHeader1 = By.xpath("//h1[contains(text(),'GTPL')]");
    private By feeSummaryHeader2 = By.xpath("//h1[contains(text(),'TRANSCORP')]");
    private By submitBtn = By.xpath("//button[text()='Submit']");
    private By totalFeesList = By.cssSelector("div.margin-bottom-9 div.col-md-4");
    private By paymentTimeGraph = By.xpath("//div[text()='Payment Trend - Time']");
    private By paymentTrendGraph = By.xpath("//div[text()='Payment Trend - Method']");
    private By dayBtn = By.xpath("//div[text()='Day']");
    private By monthBtn = By.xpath("//div[text()='Month']");
    private By yearBtn = By.xpath("//div[text()='Year']");
    private By graph = By.cssSelector("#container");
    private By dateText = By.xpath("//div[text()='Date']");

    public SummaryPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getPageUrl(){
        String Url =eleUtil.waitforURLContainsAndReturns(AppConstants.DASHBOARD_PAGE_FRACTION_URL,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Student Summary page title :"+ Url);
        return Url;
    }
    public boolean isFeeSummaryHeaderExist(){
        eleUtil.waitforElementVisible(feeSummaryOverAllHeader,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(feeSummaryOverAllHeader);
    }
    public List<String> getFeeSummaryHeadersList(){
        List <WebElement> headersList = eleUtil.waitForElementsVisible(feeSummaryHeaders,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List <String> headersListText = new ArrayList<String>();
        for(WebElement e : headersList){
            String headerText = e.getText();
            headersListText.add(headerText);
        }
        return headersListText;
    }
    public boolean getCountOfHeadersList(){
       int count = eleUtil.waitForElementsVisible(feeSummaryHeaders,AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
        if(count==AppConstants.FEE_SUMMARY_LIST_HEADER_COUNT){
            return true;
        }
        return false;
    }
    public void getSummaryHeadersView(){
        getFeeSummaryHeadersList().contains("GTPL");
        eleUtil.scrollToElement(feeSummaryHeader1);
        getFeeSummaryHeadersList().contains("TRANSCORP");
        eleUtil.scrollToElement(feeSummaryHeader2);
    }
    public boolean isSubmitBtnExist(){
        eleUtil.waitforElementpresence(submitBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(submitBtn);
       return eleUtil.isElementDisplayed(submitBtn);
    }
    public boolean getTotalFeeTrends(){
        eleUtil.waitforElementpresence(totalFeesList,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(totalFeesList);
        return eleUtil.isElementDisplayed(totalFeesList);
    }
    public boolean getPaymentTimeGraph(){
        eleUtil.waitforElementpresence(paymentTimeGraph,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(paymentTimeGraph);
        return eleUtil.isElementDisplayed(paymentTimeGraph);
    }
    public boolean getPaymentTrendGraph(){
        eleUtil.waitforElementpresence(paymentTrendGraph,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(paymentTrendGraph);
        return eleUtil.isElementDisplayed(paymentTrendGraph);
    }
    public boolean isGraphExist(){
        eleUtil.waitforElementpresence(graph,AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        eleUtil.scrollToElement(graph);
        return eleUtil.isElementDisplayed(graph);
    }
    public boolean getDayMonthYearBtns(){
        getPaymentTimeGraph();
        eleUtil.scrollToElement(dateText);
        eleUtil.waitforElementVisible(dayBtn,AppConstants.DEFAULT_SHORT_TIME_OUT).click();
        eleUtil.waitforElementVisible(monthBtn,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
        eleUtil.waitforElementVisible(yearBtn,AppConstants.DEFAULT_SHORT_TIME_OUT);
        return eleUtil.isElementDisplayed(paymentTimeGraph);
    }

}
