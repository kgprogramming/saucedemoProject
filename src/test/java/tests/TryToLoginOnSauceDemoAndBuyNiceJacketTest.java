package tests;

import main.MainMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SauceDemo.*;

public class TryToLoginOnSauceDemoAndBuyNiceJacketTest extends MainMethods {
    LoginOnSauceDemo log=new LoginOnSauceDemo();
@BeforeClass
    public void setUp() {
        createDriver();
        openApplication("https://www.saucedemo.com/");
    }
    @Test
    public void test01LoginWithoutPopulatedFields(){
        createReport("Check if users are able to login without populating input fields ");
        log.verificationTittleYouDontHaveAUserIsNotVisible()
        .clickOnLoginButton();log.verificationYouDontHaveAUsernameIsNowVisible();
    }
    @Test
    public void test02LoginWithoutPassword(){
        createReport("Check if users are able to login without password ");
        refreshPage();
      log.verificationYouDontHaveAPass().enterUsernameInInputField("standard_user").clickOnLoginButton();log.verifyThatYouDontHaveAPassword();
    }
    @Test
    public void test03LoginWithWrongUsernameAndPassword(){
        createReport("Check if users are able to login with wrong username and password ");
        refreshPage();
        log.verificationYouDontHaveAPass().verificationTittleYouDontHaveAUserIsNotVisible().enterUsernameInInputField("petar").typingPassword("Petar").clickOnLoginButton();
        log.verificationYouDontHaveUsernameAndPAssword();
}

    @Test
    public void test04TryToLoginAndBuyJacket() {
        createReport("Check if users are able login and buy jacket");
        refreshPage();
        log.verificationTittleUsernameForAll().verificationThathTittlePasswordForAllIsVisible()
     .enterUsernameInInputField("standard_user").typingPassword("secret_sauce").clickOnLoginButton().verifyThatAllSixItemsAreVisible()
       .cartIsEmpty().addToCartJacket().cartIsFull().goToCart().verifyItemInCart().verifyDescriptionIsvisible()
        .clickOnCheckoutButton().verifySubheader().enterFirstName().enterLastName().enterZipCode()
        .clickOnContinueButton().verifyTotalItem().clickOnFinish().verifySuccessfully();
    }
       @AfterClass
    public void close() {
        quitDriver();
    }
}
