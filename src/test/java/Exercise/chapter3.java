package Exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class chapter3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        getEmailFree
        driver.get("https://www.guerrillamail.com/inbox");

        WebElement domainEmail = driver.findElement(By.xpath("//select[@id = 'gm-host-select']"));
        Select selectdomainEmail = new Select(domainEmail);
        selectdomainEmail.selectByVisibleText("spam4.me");

        WebElement emailFree = driver.findElement(By.xpath("//span[@id = 'email-widget']"));
        String emailFreeText = emailFree.getText();

        Thread.sleep(5000);

//        createNewAccount

        driver.get("http://www.saferailway.somee.com/");

        WebElement registerTab = driver.findElement(By.xpath("//span[text() = 'Register']/parent::a"));
        registerTab.click();

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id = 'email']"));
        emailTextBox.sendKeys(emailFreeText);
        emailTextBox.sendKeys(Keys.TAB);

        String pw = "123456789";
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordTextBox.sendKeys(pw);
        passwordTextBox.sendKeys(Keys.TAB);

        WebElement confirmPWTextBox = driver.findElement(By.xpath("//input[@id = 'confirmPassword']"));
        confirmPWTextBox.sendKeys(pw);
        confirmPWTextBox.sendKeys(Keys.TAB);

        WebElement pidTextBox = driver.findElement(By.xpath("//input[@id = 'pid']"));
        pidTextBox.sendKeys("123456789");
        pidTextBox.sendKeys(Keys.TAB);

        WebElement registerBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
        registerBtn.click();

//        confirmEmail
        driver.navigate().to("https://www.guerrillamail.com/inbox");
        Thread.sleep(15000);

        List<WebElement> emailList = driver.findElements(By.xpath("//tr[contains(@class, 'mail_row')]"));

        if (emailList.size() > 0) {
            emailList.get(0).click();
            WebElement confirmLink = driver.findElement(By.xpath("//div[@class = 'email_body']/a"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmLink);

            if (confirmLink != null) {
                confirmLink.click();
            }
        } else {
            System.out.println("No confirm email found in the inbox.");
        }
        driver.close();
//        QuayveTabdautien
        Set<String> windowHandles = driver.getWindowHandles();
        String firstTab = (String)windowHandles.toArray()[0]; //Tab đầu
        driver.switchTo().window(firstTab);

//        login
        driver.get("http://www.saferailway.somee.com/");

        WebElement loginTab = driver.findElement(By.xpath("//span[text() = 'Login']//parent::a"));
        loginTab.click();

        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id = 'username']"));
        usernameTextBox.sendKeys(emailFreeText);
        usernameTextBox.sendKeys(Keys.TAB);

        WebElement pwTextBox = driver.findElement(By.xpath("//input[@id = 'password']"));
        pwTextBox.sendKeys(pw);
        pwTextBox.sendKeys(Keys.TAB);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
        loginBtn.click();

//        book2tickettoPhanThiet
        WebElement bookTicketTab = driver.findElement(By.xpath("//div[@id ='menu']/ul/li/a/span[text() = 'Book ticket']/parent::a"));
        bookTicketTab.click();

        WebElement departDateDropDown = driver.findElement(By.xpath("//select[@name ='Date']"));
        Select selectDate = new Select(departDateDropDown);
        selectDate.selectByVisibleText("8/29/2024");

        WebElement arriveAtDropDown = driver.findElement(By.xpath("//select[@name ='ArriveStation']"));
        Select selectArriveAt = new Select(arriveAtDropDown);
        selectArriveAt.selectByVisibleText("Phan Thiết");

        WebElement ticketAmountDropDown =driver.findElement(By.xpath("//select[@name ='TicketAmount']"));
        Select selectAmount = new Select(ticketAmountDropDown);
        selectAmount.selectByVisibleText("2");

        WebElement bookTicketBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        bookTicketBtn.click();

        driver.quit();
    }
}
