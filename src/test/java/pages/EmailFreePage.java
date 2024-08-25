package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class EmailFreePage {
    private WebDriver driver;

    //Locators
    private By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    private By emailFree = By.xpath("//span[@id = 'email-widget']");
    private By emailconfirm = By.xpath("//tr[contains(@class, 'mail_row')]");
    private  By confirmLink = By.xpath("//div[@class = 'email_body']/a");

    // Constructor
    public EmailFreePage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }

    //Method to navigate to Email Free Page
    public void getEmailFree() {
        driver.get("https://www.guerrillamail.com/inbox");

        driver.findElement(domainEmail);
        Select selectdomainEmail = new Select((WebElement) domainEmail);
        selectdomainEmail.selectByVisibleText("spam4.me");

        String email = driver.findElement(emailFree).getText();

    }

    //Method to confirm email
    public void confirmEmail() {
        driver.get("https://www.guerrillamail.com/inbox");

        List<WebElement> emailList = driver.findElements(emailconfirm);

        if (emailList.size() > 0) {
            emailList.get(0).click();
            WebElement confirmLink = driver.findElement(By.xpath("//div[@class = 'email_body']/a"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmLink);
            Thread.sleep(5000);

            if (confirmLink != null) {
                confirmLink.click();
            }
        } else {
            System.out.println("No confirm email found in the inbox.");
        }
    }
}
