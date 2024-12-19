package com.qa.instituteDashboard.factory;

import com.qa.instituteDashboard.errors.AppError;
import com.qa.instituteDashboard.exceptions.BrowserException;
import com.qa.instituteDashboard.exceptions.FrameworkException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.sql.DriverManager.getDriver;

public class DriverFactory {
    WebDriver driver;
    Properties prop;

    public static String isHighlight;

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
    /**
     * This method is to init the driver on basis of given browser name
//     * @param browserName
     * @return driver
     *
     **/
    public WebDriver initDriver(Properties prop) {
//	In init driver we r giving whole prop file reference -> value by reference
        String browserName =prop.getProperty("browser");
        System.out.println("browser name is : "+ browserName);

        isHighlight = prop.getProperty("highlight");

        OptionsManager optionsManager = new OptionsManager(prop);

        switch (browserName) {
            case "chrome":
//                driver = new ChromeDriver();
                tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                break;
            case "firefox":
//                driver = new FirefoxDriver();
                tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                break;
            case "edge":
//                driver = new EdgeDriver();
                tldriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
                break;
            case "safari":
//                driver = new SafariDriver();
                tldriver.set(new SafariDriver());
                break;

            default:
                System.out.println(AppError.INVALID_BROWSER_MESG + browserName + " Is InValid" );
                throw new BrowserException(AppError.INVALID_BROWSER_MESG+ browserName);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url"));
        return getDriver();
}


public static  WebDriver getDriver(){
        return tldriver.get();
}


// to run tests in maven, install mvn
//    mvn clean install -Denv ="qa"

public Properties initProp(){
        prop = new Properties();
        FileInputStream ip = null;

        String envName= System.getProperty("env");

        try {
            if (envName == null) {
                System.out.println("env is null... hence running on qa env");
                ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
            } else {
                switch (envName.toLowerCase().trim()) {
                    case "uat":
                        ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
                        break;
                    case "prod":
                        ip = new FileInputStream("./src/test/resources/config/config.properties");
                        break;
                    case "stage":
                        ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
                        break;
                    default:
                        System.out.println("plz pass the write env :" + envName);
                        throw new FrameworkException("===INVALID ENV NAME===");
                }

            }
            prop.load(ip);
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
}
    /**
     * take screenshot
     */
    public static String getScreenshot(String methodName) {
        File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); // temp dir
        String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
