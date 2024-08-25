package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class fixChapter5 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //dùng %s thay cho các giá trị tương tự nhau

        driver.get("http://www.saferailway.somee.com/");

        String sTabMenu = "//li//a[span[text() = '%s']]";
        String sCheckPrice = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'check price']";
        String sBookTicket = "//td[text() = '%s']/following-sibling::td/a";
        //Open login tab:
        WebElement loginTab = driver.findElement(By.xpath(String.format(sTabMenu,"Login")));
        loginTab.click();

        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id = 'username']"));
        WebElement pwTextBox = driver.findElement(By.xpath("//input[@id = 'password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));

        //Open Timetable tab
        WebElement timetableTab = driver.findElement(By.xpath(String.format(sTabMenu,"Timetable")));

        //Check price of train from SG to DN
        WebElement checkPriceSGDN = driver.findElement(By.xpath(String.format(sCheckPrice,"Sài Gòn", "Đà Nẵng")));
        checkPriceSGDN.click();

        //Book ticket base seat type
        WebElement bookTicketSS = driver.findElement(By.xpath(String.format(sBookTicket,"Soft seat")));
        bookTicketSS.click();

        driver.quit();


    }
}

