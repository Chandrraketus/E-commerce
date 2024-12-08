package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"btn ml-3\"]")
    WebElement logimage;

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement pass;

    @FindBy(xpath = "//button[@id='customerloginForm']")
    WebElement signin;

    @FindBy(xpath = "//li[2]//div[1]//button[1]")
    WebElement logoutimage;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutclick;

    public void portalLogin(String username, String password) {
        logimage.click();
        email.sendKeys(username);
        pass.sendKeys(password);
        signin.click();

    }

    public void logout() {
        logoutimage.click();
        logoutclick.click();
    }

}