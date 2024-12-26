package com.qa.instituteDashboard.base;

import com.qa.instituteDashboard.factory.DriverFactory;
import com.qa.instituteDashboard.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    DriverFactory df;
    protected Properties prop;
    protected LoginPage loginPage;
    protected DashBoardPage dashBoardPage;
    protected StudentListPage studentListPage;
    protected LoanApplicationPage loansPage;
    protected AddStudentPage addStudentPage;
    protected FeeStructurePage feeStructurePage;
    protected CoinsRequestPage coinsRequestPage;
    protected BulkActionPage bulkActionPage;
    protected Leo1CardPage leo1CardPage;

    @BeforeTest
    public void setup(){
        df= new DriverFactory();
        prop = df.initProp();
        driver= df.initDriver(prop);
        loginPage= new LoginPage(driver);
    }
    @AfterTest
    public void tearDown(){
//        driver.quit();
    }
}
