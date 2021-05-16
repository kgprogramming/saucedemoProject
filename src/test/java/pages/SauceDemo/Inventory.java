package pages.SauceDemo;

import com.relevantcodes.extentreports.LogStatus;
import main.MainMethods;
import org.openqa.selenium.By;

public class Inventory extends MainMethods {
    private final By backpack =By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Backpack']");
    private final By bikeLight =By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Bike Light']");
    private final By tshirt =By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Bolt T-Shirt']");
    private final By tshirt2 =By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Fleece Jacket']");
    private final By redTshrirt =By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Onesie']");
    private final By top=By.xpath("//div[@class='inventory_item_name'][text()='Test.allTheThings() T-Shirt (Red)']");
    private final By cart =By.xpath("//div[@id='shopping_cart_container']");
    private final By addJacket =By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private final By youDontHaveAuser = By.xpath("//h3[@data-test='error'][text()='Username is required']");
    private final By youDontHaveAPass =By.xpath("//h3[@data-test='error'][text()='Password is required']");
    private final By wrongUSernameAndPAss =By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
    private final By cartISful=By.xpath("//a[@class='shopping_cart_link']//span[1]");

    public Inventory verifyThatAllSixItemsAreVisible(){
        verifyThatElementIsVisible(backpack);
        verifyThatElementIsVisible(bikeLight);
        verifyThatElementIsVisible(tshirt);
        verifyThatElementIsVisible(tshirt2);
        verifyThatElementIsVisible(redTshrirt);
        verifyThatElementIsVisible(top);
        test.log(LogStatus.INFO, "All six items are visible");

        return this;
    }
    public Inventory cartIsEmpty(){
        verifyThatElementIsNotVisible(cartISful);
        test.log(LogStatus.INFO, "Bag is empty");
        return this;
    }
    public Inventory addToCartJacket(){
        click(addJacket);
        test.log(LogStatus.INFO, "Jacket is added in cart");
        return this;
    }
    public Inventory cartIsFull(){
        verifyThatElementIsVisible(cartISful);
        test.log(LogStatus.INFO, "Cart is now full");
        return this;
    }
    public Cart goToCart(){
        click(cart);
        test.log(LogStatus.INFO, "Cart is clicked");
        return new Cart();
    }
    public Inventory verifyThatElementYoudontHaveAUserIsVisible(){
        verifyThatElementIsVisible(youDontHaveAuser);
        test.log(LogStatus.INFO, "[You don't have a username] is now visible");
        return this;
    }
    public Inventory verifyThatYouDontHaveAPassword(){
        verifyThatElementIsVisible(youDontHaveAPass);
        test.log(LogStatus.INFO, "[You don't have a username] is now visible");
        return this;
    }
    public Inventory verificationYouDontHaveUsernameAndPAssword(){
        verifyThatElementIsVisible(wrongUSernameAndPAss);
        test.log(LogStatus.INFO, "[You don't have a username and password] is now visible");
        return this;
    }
}

