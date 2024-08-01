package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.P001_Registration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P001_Registration extends Pages.base {
    public P001_Registration(WebDriver driver) {
        super(driver);
    }
    public final By register =By.className("ico-register");
    public void goToRegistrationPage(){
        click(register);
    }
    public final By gender = By.id("gender-female");
    public void chooseGender(){
        click(gender);
    }
    public final By FirstName = By.id("FirstName");
    public final By LastName = By.id("LastName");
    public final By day = By.xpath("//*[@name=\"DateOfBirthDay\"]");
    public final By daySelect = By.xpath("//*[@name=\"DateOfBirthDay\"]//*[@value=\"10\"]");
    public final By month = By.cssSelector("select[name=\"DateOfBirthMonth\"]");
    public final By monthSelect = By.xpath("//*[@name=\"DateOfBirthMonth\"]//*[@value=\"7\"]");
    public final By year = By.cssSelector("select[name=\"DateOfBirthYear\"]");
    public final By yearSelect = By.xpath("//*[@name=\"DateOfBirthYear\"]//*[@value=\"1996\"]");
    public final By Email = By.id("Email");
    public final By Company = By.id("Company");
    public final By Password = By.id("Password");
    public final By ConfirmPassword = By.id("ConfirmPassword");
    public final By register_button = By.id("register-button");

    public void registerWithValidData (String firstName, String lastName, String email,String password){
        sendKeys(FirstName,firstName);
        sendKeys(LastName,lastName);
        sendKeys(Email,email);
        sendKeys(Company,"Hsoub");
        sendKeys(Password,password);
        sendKeys(ConfirmPassword,password);
    }
    public void selectDate() throws InterruptedException {
        click(day);
        click(daySelect);
        Thread.sleep(1000);
        click(month);
        click(monthSelect);
        Thread.sleep(1000);
        click(year);
        click(yearSelect);
        Thread.sleep(1000);
        click(register_button);
    }
    public final By registerContinueButton = By.cssSelector("a[class=\"button-1 register-continue-button\"]");
    public void clickRegisterContinueButton(){
        click(registerContinueButton);
    }
    public final By logout = By.xpath("//*[@href=\"/logout\"]");
    public void clickLogout(){
        click(logout);
    }
    public final By login = By.className("ico-login");
    public void clickLogin(){
        click(login);
    }
    public final By loginEmail = By.id("Email");
    public final By loginPassword = By.id("Password");
    public final By login_button = By.cssSelector("button[class=\"button-1 login-button\"]") ;
    public void loginWithValidData (String email,String password){
        sendKeys(loginEmail,email);
        sendKeys(loginPassword,password);
        click(login_button);
    }
    public final By computers = By.cssSelector("a[href=\"/computers\"]");
    public final By categoryDesktops = By.cssSelector("img[alt=\"Picture for category Desktops\"]");
    public final By LenovoProduct = By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000023_lenovo-ideacentre-600-all-in-one-pc_415.jpeg\"]");
    public final By product_enteredQuantity = By.id("product_enteredQuantity_3");
    public final By addToCartButton = By.cssSelector("button[id=\"add-to-cart-button-3\"]");
    public final By cartButton = By.xpath("//*[@id=\"topcartlink\"]//*[@href=\"/cart\"]");
    public void add10ProductsToCart (String productNum) {
        click(computers);
        click(categoryDesktops);
        click(LenovoProduct);
        sendKeys(product_enteredQuantity,productNum);
        click(addToCartButton);
        click(cartButton);
    }
    public final By termsOfService = By.cssSelector("input[id=\"termsofservice\"]");
    public void clickTermsOfService(){
        click(termsOfService);
    }
    public final By checkout = By.cssSelector("button[id=\"checkout\"]");
    public void clickCheckout(){
        click(checkout);
    }
    public final By BillingNewAddress_Country = By.id("BillingNewAddress_CountryId");
    public final By BillingNewAddress_CountrySelect = By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]//*[@value=\"1\"]");
    public final By BillingNewAddress_State  = By.id("BillingNewAddress_StateProvinceId");
    public final By BillingNewAddress_StateSelect = By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]//*[@value=\"1\"]");

    public void selectCountry() throws InterruptedException {
        click(BillingNewAddress_Country);
        click(BillingNewAddress_CountrySelect);
        click(BillingNewAddress_State);
        click(BillingNewAddress_StateSelect);
    }
    public final By BillingNewAddress_City =  By.id("BillingNewAddress_City");
    public final By BillingNewAddress_Address1 = By.id("BillingNewAddress_Address1");
    public final By BillingNewAddress_ZipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    public final By BillingNewAddress_PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public final By BillingButton = By.cssSelector("button[onclick=\"if (!window.__cfRLUnblockHandlers) return false; Billing.save()\"]");
    public final By nextStepButton = By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]");
    public void endShippingSteps (String City, String Address,String ZipPostalCode, String phone){
        sendKeys(BillingNewAddress_City,City);
        sendKeys(BillingNewAddress_Address1,Address);
        sendKeys(BillingNewAddress_ZipPostalCode,ZipPostalCode);
        sendKeys(BillingNewAddress_PhoneNumber,phone);
        click(BillingButton);
        click(nextStepButton);
    }
}
