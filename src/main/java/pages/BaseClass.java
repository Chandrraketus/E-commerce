package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
//import utilities.BrowserUtility;
import utilities.ConfigManager;
import utilities.ReadExcelFile;
import utilities.ConfigManager;

public class BaseClass {
    public WebDriver driver;
    public ConfigManager conf = new ConfigManager();
    protected ReadExcelFile excel;

    @BeforeClass
    public void setup() {
        // Load browser and navigate to the URL
        String browser = conf.getBrowser();
        String url = conf.getUrl();
        System.out.println("Starting tests on browser: " + browser + " and URL: " + url);
        driver = BrowserFactory.startApplication(driver, browser, url);
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            System.out.println("Closing the browser.");
//            driver.quit();
//        }
    }
