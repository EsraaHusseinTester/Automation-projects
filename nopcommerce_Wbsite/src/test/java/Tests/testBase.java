package Tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class testBase {
    WebDriver driver;
    Faker fake = new Faker();
    SoftAssert soft = new SoftAssert();
    String name = fake.name().fullName();
    String CountryId = fake.country().name();
    String City = fake.address().cityName();
    String Address = fake.address().fullAddress();
    String ZipPostalCode = fake.address().zipCode();
    String firstName = fake.name().firstName();
    String lastName = fake.name().lastName();
    String email = fake.internet().safeEmailAddress();
    String password = fake.internet().password();
    int salary = fake.number().numberBetween(1000,99999);
    String phone = "10"+fake.number().numberBetween(10000000,99999999);
    String productNum = "10";


    @BeforeSuite
    public void BeforeSuite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/adBlockExtention.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.get("https://demo.nopcommerce.com/");

    }
    @AfterSuite
    public  void AfterSuite(){
//        driver.quit();
    }

}
