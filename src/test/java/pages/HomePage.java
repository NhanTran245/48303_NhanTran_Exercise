package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    String sTabMenu = "//li//a[span[text() = '%s']]";

    //Locator
    private By registerTab = By.xpath(String.format(sTabMenu,"Register"));
    private By loginTab = By.xpath(String.format(sTabMenu,"Login"));
    private By timetableTab = By.xpath(String.format(sTabMenu,"Timetable"));
    private By bookTicketTab = By.xpath(String.format(sTabMenu,"Book ticket"));

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

}
