package Exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class chapter5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login(driver);

        bookTicketFromTrainTimetable(driver);

        driver.quit();

    }
    public static void login(WebDriver driver) throws InterruptedException {

        // Method to get Email Free
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
            Thread.sleep(5000);

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
    }

    public static void bookTicketFromTrainTimetable (WebDriver driver) throws InterruptedException {

        WebElement timeTableTab = driver.findElement(By.xpath("//div[@id ='menu']/ul/li/a/span[text() = 'Timetable']/parent::a"));
        timeTableTab.click();

        WebElement checkPriceBtn = driver.findElement(By.xpath("//td[text() = 'Sài Gòn']/following-sibling::td[text() = 'Đà Nẵng']/following-sibling::td/a[text() = 'check price']"));
        //Xpath: //tr[td[text() = 'Sài Gòn' and following-sibling::td[text() = 'Đà Nẵng']]]//a[text() = 'check price']
        checkPriceBtn.click();

        WebElement bookTicketBtn = driver.findElement(By.xpath("//td[text() = 'Soft seat']/following-sibling::td/a"));
        bookTicketBtn.click();

        //tinh toan ngay hien tai + 7
        LocalDate curentDate = LocalDate.now();
        LocalDate departDate = curentDate.plusDays(7);

        // Định dạng ngày thành chuỗi theo định dạng yêu cầu trong dropdown (ví dụ: MM/dd/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = departDate.format(formatter);

        WebElement departDateDropDown = driver.findElement(By.xpath("//select[@name ='Date']"));
        // Khởi tạo đối tượng Select với phần tử <select>
        Select selectDate = new Select(departDateDropDown);
        selectDate.selectByVisibleText(formattedDate);

        WebElement ticketAmountDropDown =driver.findElement(By.xpath("//select[@name ='TicketAmount']"));
        Select selectAmount = new Select(ticketAmountDropDown);
        selectAmount.selectByVisibleText("2");

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        confirmBtn.click();

        WebElement confirmText = driver.findElement(By.xpath("//h1"));
        String confirmBookTicket = confirmText.getText();
        String expectedText = "Ticket booked successfully!";

        if (confirmBookTicket.equals(expectedText)) {
            System.out.println("Ticket booked successfully! with corrected ticket info");
        } else {
            System.out.println("booked ticket info is wrong");
        }

    }
//    Login Railway System with a valid account
//    Click on Timetable tab
//    Click on “check price” of Sai Gon-Da Nang
//    Click on “book ticket” of “Soft seat”
//    Choose Depart date is next week (next 7 days) and Ticket amount is 2
//    Click on “book ticket”
}
