package Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class HelloSeleniumWorld {


    public static void main(String[] args) {
        //Run test with Chrome
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("https://www.selenium.dev/documentation/");
        String chromeTitle = chromeDriver.getTitle();

        if (chromeTitle.equals("The Selenium Browser Automation Project | Selenium")) {
            System.out.println("Web Title is: “The Selenium Browser Automation Project | Selenium”");
        } else {
            System.out.println("Web Title is NOT: “The Selenium Browser Automation Project | Selenium”");
        }
        chromeDriver.quit();

        //Run test with Firefox
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firefoxDriver.get("https://www.selenium.dev/documentation/");
        String firefoxTitle = firefoxDriver.getTitle();

        if (firefoxTitle.equals("The Selenium Browser Automation Project | Selenium")) {
            System.out.println("Web Title is: “The Selenium Browser Automation Project | Selenium”");
        } else {
            System.out.println("Web Title is NOT: “The Selenium Browser Automation Project | Selenium”");
        }
        firefoxDriver.quit();
    }
}
