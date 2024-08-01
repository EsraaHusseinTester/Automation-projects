package Tests;

import Pages.P001_Registration;
import org.testng.annotations.Test;

public class T001_Registration extends testBase {
    P001_Registration registration;
    @Test
    public void registerWithValidData() throws InterruptedException {
        registration = new P001_Registration(driver);
        registration.goToRegistrationPage();
        registration.chooseGender();
        registration.registerWithValidData(firstName,lastName,email,password);
        registration.selectDate();
        registration.clickRegisterContinueButton();
        registration.clickLogout();
        registration.clickLogin();
        registration.loginWithValidData(email,password);
        registration.add10ProductsToCart(productNum);
        registration.clickTermsOfService();
        registration.clickCheckout();
        registration.selectCountry();
        registration.endShippingSteps(City, Address, ZipPostalCode,  phone);

    }
}
