package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static utils.Browsers.*;
import utils.Config;
import utils.Driver;
import utils.MainFramework;

public class Test1 extends MainFramework {

    String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    By username = By.cssSelector("#txtUsername");
    By password = By.cssSelector("#txtPassword");
    By loginButton = By.cssSelector("#btnLogin");


    @Test
    public void test01(){
        //Config.browser = CHROME;
        Config.maximized = true;
        Config.width = 900;
        Config.height = 600;

        open(url);
        sendKeys(username, "Admin");
        sendKeys(password, "admin123");
        click(loginButton);

        bekle(3000);
        Driver.quitDriver();
    }
}
