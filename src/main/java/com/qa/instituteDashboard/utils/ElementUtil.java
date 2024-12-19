package com.qa.instituteDashboard.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.instituteDashboard.exceptions.FrameworkException;
import com.qa.instituteDashboard.factory.DriverFactory;

public class ElementUtil {

    private	WebDriver driver;
    private Actions act;
    private JavaScriptUtil jsUtil;

    public ElementUtil(WebDriver driver) {
        this.driver=driver;
        act = new Actions(driver);
        jsUtil = new JavaScriptUtil(driver);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }
    public void doClear(By locator) {
        getElement(locator).clear();
    }
    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
    //	public void doSendKeys(By locator, CharSequence...valuee) {
//		getElement(locator).sendKeys(valuee);
//	}
    public void doSendKeysWithClear(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public  Boolean isElementDisplayed(By locator) {// custom method

        try {
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("element isn't displayed");
            return false;
        }
    }

    public Boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public Boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public String dogetElementText(By locator) {
        String eleText= getElement(locator).getText();

        if(eleText!=null) {
            return eleText;
        }
        else {
            System.out.println("given text is null:"+ eleText);
            return null;
        }
    }
    public  boolean isElementPresent(By locator) {
        if(getFindElementsCount(locator)==0) {
            return true;
        }
        return false;
    }

    public boolean isElementPresent(By locator, int exepectedCount) {
        if(getFindElementsCount(locator)==exepectedCount) {
            return true;
        }
        return false;
    }
    public  boolean isElementNotPresent(By locator) {
        if(getFindElementsCount(locator)==0) {
            return true;
        } return false;
    }
    public  boolean isElementPresentMultipleTimes(By locator) {
        if(getFindElementsCount(locator)>=1) {
            return true;
        }return false;
    }

    //	this method used when element is highlighted it will flash
    private void checkElementHighlight(WebElement element) {
        if(Boolean.parseBoolean(DriverFactory.isHighlight)) {
            jsUtil.flash(element);
        }
    }
    //	method over loading
    public  WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        checkElementHighlight(element);
        return element;
    }
//    public void getFindElement(WebElement element){
//        driver
//    }
    public WebElement waitforElementpresence(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element =	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        checkElementHighlight(element);
        return element;

    }
    public WebElement waitforElementVisible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        checkElementHighlight(element);
        return element;
    }
    // using web element
    public WebElement waitforElementVisible(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return	wait.until(ExpectedConditions.visibilityOf(element));

    }
    //customized polling time
    public WebElement waitforElementVisible(By locator, int time, int timeInterval) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time), Duration.ofSeconds(timeInterval));
        WebElement element =	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        checkElementHighlight(element);
        return element;
    }// waits with fluent wait features
    /***
     * wait for element visible on page with fluent wait features
     * @param locator
     * @param time
     * @param pollingTime
     * @return

     ***/
    public WebElement waitforElementVisibleWithFluentWaitFeatures(By locator, int time, int pollingTime) {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .withMessage("=== element not found ===");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementAndClick(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    //	wait for all elements to visible
    public  List<WebElement> waitForElementsVisible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public  String getAttributeValue(By locator, String value) {
        return getElement(locator).getAttribute(value);
    }

    public  int getFindElementsCount(By locator) {
        return getFindElements(locator).size();
    }

    public  List<WebElement> getFindElements(By locator) {
        return driver.findElements(locator);
    }
//	******

    public  void doSearch(By searchField, By suggestions,String suggestName, String matchValue) throws InterruptedException {

        doSendKeys(searchField, suggestName);
        Thread.sleep(2000);

        List<WebElement> suggestElement =getFindElements(suggestions);
        int totalNumber= suggestElement.size();
        System.out.println(" Total number of suggestions : "+ totalNumber);

        if(totalNumber==0) {
            System.out.println("no suggestions found");
            throw new FrameworkException("no suggestion FOUND....");
        }

        for(WebElement e: suggestElement) {
            String Text= e.getText();
            System.out.println(Text);
            if(Text.contains(matchValue)) {
                e.click();
                break;
            }
        }
    }

//	***********select DropDown*************//

    private Select getSelect(By locator) {
        return new Select(getElement(locator));
    }


    public int getDropDownOptions(By locator) {
        return getSelect(locator).getOptions().size();
    }
    public  void selectDropDownValueByVisibleText(By locator, String visibleText) {
        getSelect(locator).selectByVisibleText(visibleText);
    }
    public  void selectDropDownValueByValue(By locator, String value) {
        getSelect(locator).selectByValue(value);
    }
    public  void selectDropDownValueByIndex(By locator, int index) {
        getSelect(locator).selectByIndex(index);
    }
    public  List<String> getDropDownTextList(By locator) {
        List<WebElement> list=getSelect(locator).getOptions();
        System.out.println("total number of options"+list.size());
        List <String> optionsTextList= new ArrayList<String>();
        for (WebElement e : list) {
            String text= e.getText();
            optionsTextList.add(text);
        }
        return optionsTextList;
    }

    //	*** Select dropDown value  using select class***
    public  void selectDropDownValueBySelect(By locator, String value) {
        List<WebElement> list=getSelect(locator).getOptions();
        selectDropDown(list, value);
    }

    //	*** Select dropDown value without using select class***
    public  void SelectDropDownValue(By locator, String value) {
        List<WebElement> CountryList= getFindElements(locator);
        selectDropDown(CountryList, value);
    }

    private void selectDropDown(List<WebElement> CountryList, String value) {
        System.out.println("total number of options"+ CountryList.size());
        for (WebElement e : CountryList) {
            String text = e.getText();
            System.out.println(text);
            if(text.equals(value)) {
                e.click();
                break;
            }

        }
    }
    //	**********Actions Utils*******
    public  void doActionSendKeys(By locator, String name) {
        act.sendKeys(getElement(locator), name).perform();
    }

    public  void doActionsClick(By locator) {
        act.click(getElement(locator)).perform();
    }

//	Actions on Right Click

    public  void doRightClick(By right, By copy) {
        act.contextClick(getElement(right)).perform();
        doClick(copy);
    }
    //	SendKeys with pause Actions
    public  void doActionsSendKeysWithPause(By locator,String value, long pauseTime) {
        char ch[]= value.toCharArray();
        for (char c : ch) {
            act.sendKeys(getElement(locator), String.valueOf(c)).pause(pauseTime).perform();
        }
    }
//    move to element with only one element
    public void scrollToElement(By element)  {
        act.moveToElement(getElement(element)).perform();
//        Thread.sleep(1000);
    }


    //This menu is handling 2 levels parent & child
    public  void ParentChildMenu(By parent, By child) throws InterruptedException {
        act.moveToElement(getElement(parent)).perform();
        Thread.sleep(1000);
        doClick(child);

    }
    public  void ParentChildMenu(String parent, String child) throws InterruptedException {
        act.moveToElement(getElement(By.xpath("//div[text()='"+parent+"']"))).perform();
        Thread.sleep(1000);
        doClick(By.xpath("//div[text()='"+child+"']"));

    }
    public  void ParentChildMenu(By first, By second, By third, By fourth) throws InterruptedException {
        doClick(first);
        Thread.sleep(1000);
        act.moveToElement(getElement(second)).perform();
        Thread.sleep(1000);
        act.moveToElement(getElement(third)).perform();
        Thread.sleep(1000);
        doClick(fourth);

    }
//  get titles after explicit waits

    public String getTitleIs(String Expectedtitle, int timeout) {
        if(waitforTitleIs(Expectedtitle, timeout)) {
            return driver.getTitle();
        }
        else {
            return "-1";
        }
    }
    public String getTitleContains(String fractiontitle, int timeout) {
        if(waitforTitleContains(fractiontitle, timeout)) {
            return driver.getTitle();
        }
        else {
            return "-1";
        }
    }

    public Boolean waitforTitleIs(String Expectedtitle, int timeout) {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(timeout));
        Boolean flag= false;
        try {
            return wait.until(ExpectedConditions.titleIs(Expectedtitle));//if title not matched, it throw timeout exception
        }
        catch(TimeoutException e){
            System.out.println("Title is not matched");
            return flag;
        }
    }

    public boolean waitforTitleContains(String fractiontitle, int timeout) {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(timeout));
        Boolean flag= false;
        try {
            return wait.until(ExpectedConditions.titleContains(fractiontitle));
            //if title not matched, it throw timeout exception
        }
        catch(TimeoutException e){
            System.out.println("Title is not matched");
            return flag;
        }
    }
    public String waitforTitleContainsAndReturns(String fractiontitle, int timeout) {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.titleContains(fractiontitle));
            return driver.getTitle();//if title not matched, it throw timeout exception
        }
        catch(TimeoutException e){
            System.out.println("Title is not matched");
            return "-1";
        }
    }
//	Get url with explicit waits

    public String getUrlContains(String fractiontitle, int timeout) {
        if(waitforURLContains(fractiontitle, timeout)){
            return driver.getCurrentUrl();
        }
        else {
            return "-1";
        }
    }
    public  Boolean waitforURLContains(String fractiontitle, int timeout) {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(timeout));
        Boolean flag= false;
        try {
            return wait.until(ExpectedConditions.urlContains(fractiontitle));//if title not matched, it throw timeout exception
        }
        catch(TimeoutException e){
            System.out.println("Title is not matched");
            return flag;
        }
    }
    public  String waitforURLContainsAndReturns(String fractiontitle, int timeout) {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.urlContains(fractiontitle));//if title not matched, it throw timeout exception
            return driver.getCurrentUrl();
        }
        catch(TimeoutException e){
            System.out.println("Title is not matched");
            return "-1";
        }
    }
    //	Alert with waits
    public Alert waitforAlertAndSwitch(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return  wait.until(ExpectedConditions.alertIsPresent());
    }
    public String getAlertText(int timeout) {
        return waitforAlertAndSwitch(timeout).getText();
    }
    public void acceptAlert(int timeout) {
        waitforAlertAndSwitch(timeout).accept();
    }
    public void dismissAlert(int timeout) {
        waitforAlertAndSwitch(timeout).dismiss();
    }
    public void enterValueOnAlert(int timeout, String value) {
        waitforAlertAndSwitch(timeout).sendKeys(value);
    }
    //	Frames with wait
    public void waitForFramesUsingLocatorAndSwitchToIT(By framelocator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
    }
    public void waitForFramesUsingIndexAndSwitchToIT(int index, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    //wait for windows
    public Boolean waitForNewWindowOrTab(int timeout, int noOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            if(wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows))){
                return true;
            }
        }
        catch(TimeoutException e) {
            System.out.println("no of windows not matched.....");
        }
        return false;
    }
//    customized DropDowns
public WebElement selectText(String txt) {
    return driver.findElement(By.xpath("//div[contains(text(), '" + txt + "')]"));
}

    public String selectDropDownText(By locator, String text) {
        try {
            // Click on the dropdown to expand it
            getElement(locator).click();

            // Locate the desired option in the dropdown
            WebElement DD = selectText(text);

            // Use a wait to ensure the element is visible and clickable
            waitforElementVisible(DD, 20).click();

            return text;
        } catch (ElementNotInteractableException e) {
            System.err.println("Element not interactable: " + e.getMessage());
            // Retry logic or fallback mechanism if required
        } catch (StaleElementReferenceException e) {
            System.err.println("Stale element reference: " + e.getMessage());
            // Re-fetch the element and try again
            WebElement DD = selectText(text);
            waitforElementVisible(DD, 20).click();
            return text;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        return null; // Return null or handle appropriately if the operation fails
    }




//    public String selectDropDownText(By locator, String text) {
//        getElement(locator).click();
//       List<WebElement> options = driver.findElements(locator); // Update locator to target dropdown options
//        for (WebElement option : options) {
//            if (option.getText().equalsIgnoreCase(text)) {
//                waitforElementVisible(option, 10).click();
//                return option.getText(); // Return the selected option text
//            }
//        }
//        throw new NoSuchElementException("Option with text '" + text + "' not found in dropdown");
//    }

}

