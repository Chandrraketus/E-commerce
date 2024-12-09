package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
//import utilities.BrowserUtility;
import utilities.ConfigManager;
import utilities.ReadExcelFile;
import utilities.ConfigManager;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    protected String FileName = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";
    public WebDriver driver;
    public ConfigManager conf = new ConfigManager();
    public ReadExcelFile excel;
    public ReadExcelFile rf = new ReadExcelFile();
    protected LoginPage lp;

    protected String User = ReadExcelFile.getCellValue(FileName,"Login",1,0);
    protected String Password = ReadExcelFile.getCellValue(FileName,"Login",1,1);

    @BeforeClass
    public void setup() {
        // Load browser and navigate to the URL
        String browser = conf.getBrowser();
        String url = conf.getUrl();
        System.out.println("Starting tests on browser: " + browser + " and URL: " + url);
        driver = BrowserFactory.startApplication(driver, browser, url);
    }

    public void capturesreenshot(WebDriver driver,String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcPath = new File("." +"//Screenshots//" + testName +".png");
        System.out.println("This is screenshot section");

        FileUtils.copyFile(src, srcPath);

    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            System.out.println("Closing the browser.");
//            driver.quit();
//        }
    }
