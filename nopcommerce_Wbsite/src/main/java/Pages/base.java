package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class base {
    public WebDriver driver;
    Faker fake = new Faker();

//    Actions actions = new Actions(driver);

    public base (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
    public void click(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public void sendKeys (By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //    public void sendKeys(By by, int num){
//        driver.findElement(by).clear();
//        driver.findElement(by).sendKeys(num);
//    }
    public void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public void selectRandomOption(By select, By option, int min){
        Select selection = new Select(driver.findElement(select));
        int options = driver.findElements(option).size();
        int random = fake.number().numberBetween(min, options+1);
        selection.selectByIndex(random);
    }
    public static void scrollDown(WebDriver driver, By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }
}
