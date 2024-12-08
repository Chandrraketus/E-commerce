package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SearchPages {
    public WebDriver driver;
    public WebDriverWait wait;

    public SearchPages(WebDriver driver1)
    {
        this.driver = driver1;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement Homebutton;

    @FindBy(xpath="//input[@name=\"frm_search\"]")
    WebElement SearchText;

    @FindBy(xpath = "//button [@id=\"btn_search\"]")
    WebElement SearchButton;

    @FindBy(xpath = "//h3[contains(text(),'Android TV')]")
    WebElement productName;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @FindBy(xpath = "//a[@class=\"btn menu-btn\"]")
    WebElement Cart;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement CheckOut;


    public void searchProduct(String searchQuery) {
        wait.until(ExpectedConditions.elementToBeClickable(Homebutton)).click();
        wait.until(ExpectedConditions.visibilityOf(SearchText)).sendKeys(searchQuery);
        wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(productName)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Cart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CheckOut)).click();

    }
}
