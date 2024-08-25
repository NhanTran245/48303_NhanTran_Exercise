package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private HomePage homePage;
    private EmailFreePage emailFreePage;

    //Locators
    private By registerTab = By.xpath(String.format(homePage.sTabMenu,"Register"));
    private By emailTextBox = By.xpath("//input[@id = 'email']");
    private By passwordTextBox = By.xpath("//input[@id = 'password']");
    private By confirmPWTextBox = By.xpath("//input[@id = 'confirmPassword']");
    private By pidTextBox = By.xpath("//input[@id = 'pid']");
    private By registerBtn = By.xpath("//input[@type = 'submit']");

    //Constructor
    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }

    // Method to get Email Free
    public void

    // Method to navigate to Register page
    public void clickRegister() {
        driver.findElement(registerTab).click();
    }

}
