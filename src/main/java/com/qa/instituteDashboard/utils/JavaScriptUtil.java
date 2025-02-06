package com.qa.instituteDashboard.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    private WebDriver driver;
    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver){
        this.driver =driver;
        this.js= (JavascriptExecutor)driver;

    }

    public  String getPageTitle() {
        return  js.executeScript("return document.title").toString();

    }
    public  String getPageUrL() {
        return js.executeScript("return document.URL").toString();

    }
    public void getAlerts(String msg) {
        js.executeScript("alert('"+msg+"')");
    }
    public String getPageInnerText() {
        return js.executeScript("return document.documentElement.innerText;").toString();
    }
    public void ZoomForAllBrowser(String zoomPercentage) {
        String zoom ="document.body.style.zoom= '"+zoomPercentage+"%'";
        js.executeScript(zoom);
    }
    public void scrollToPageDown() {
        js.executeScript("window.scroll(0,document.body.scrollHeight)");
    }
    public void scrollToPageHorizontal() {
        js.executeScript("window.scroll(document.body.scrollHeight,0)");
    }
    public void scrollToPagemiddle() {
        js.executeScript("window.scroll(0,document.body.scrollHeight/2)");
    }
    public void scrollToPageup() {
        js.executeScript("window.scroll(document.body.scrollHeight,0)");
    }
    public void scrollToPageHeight(String height) {
        js.executeScript("window.scroll(0,'"+200+"')");
    }
    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    public void flash(WebElement element) {
        String bgcolor = element.getCssValue("backgroundColor");// white
        for(int i=0;i<10;i++) {
            changeColor("rgb(0,200.0,0)", element);	// green
            changeColor(bgcolor, element);
        }
    }
    private void changeColor(String color, WebElement element) {
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        try {
            Thread.sleep(50);
        }catch (InterruptedException e) {

        }
//		System.out.println("Current color: " + element.getCssValue("backgroundColor"));
    }
}
