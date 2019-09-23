package trello.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to navigate the page.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class PageTransporter {
    private static Map<String, String> mapPage = new HashMap<>();
    static{
        mapPage.put("login","https://trello.com/login");
    }
    public static void navigateToURL(String page){
        WebDriver driver = WebDriverManager.getInstance().getWebDriver();
        driver.navigate().to(mapPage.get(page));
    }
}
