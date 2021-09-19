package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainFramework {

    private WebDriver driver;
    private WebDriverWait wait;


    public void open(String url){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        configBrowser();
        driver.get(url);
    }

    public void configBrowser(){

        if (Config.maximized){
            driver.manage().window().maximize();
        }else {
            Dimension dimension = new Dimension(Config.width, Config.height);
            driver.manage().window().setSize(dimension);
        }

    }


    public void click(By locator){
        waitFor(locator, WaitTypes.CLICKABLE).click();
    }

    public void click(WebElement element){
        waitFor(element, WaitTypes.CLICKABLE).click();
    }

    public void sendKeys(By locator, String text){
        waitFor(locator, WaitTypes.VISIBLE).sendKeys(text);
    }

    public void sendKeys(WebElement element, String text){
        waitFor(element, WaitTypes.VISIBLE).sendKeys(text);
    }




    public WebElement waitFor(By locator, WaitTypes type){

        switch (type){
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            default:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }

    public WebElement waitFor(WebElement element, WaitTypes type){

        switch (type){
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOf(element));
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(element));
            default:
                return element;
        }
    }


    /*
    public WebElement waitForExist(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    */




    public void bekle(long miliseconds){
        try {
            Thread.sleep(miliseconds);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
