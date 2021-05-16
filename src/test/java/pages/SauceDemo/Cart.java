package pages.SauceDemo;

import com.relevantcodes.extentreports.LogStatus;
import main.MainMethods;
import org.openqa.selenium.By;

public class Cart extends MainMethods {
    private final By jacketInCart = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name'][text()='Sauce Labs Fleece Jacket']");
    private final By description =By.xpath("//div[@class='cart_desc_label']");
    private final By buttonCheckout=By.xpath("//button[@id='checkout']");
    public Cart verifyItemInCart(){
        verifyThatElementIsVisible(jacketInCart);
        test.log(LogStatus.INFO, "jacket is now in cart");
        return this;
    }
    public Cart verifyDescriptionIsvisible(){
        verifyThatElementIsVisible(description);
        test.log(LogStatus.INFO, "Description is now visible");
        return this;
    }
    public Checkout clickOnCheckoutButton(){
        click(buttonCheckout);
        test.log(LogStatus.INFO, "Button checkout is clicked");
        return new Checkout();
    }


}
