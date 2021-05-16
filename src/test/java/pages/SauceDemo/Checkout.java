package pages.SauceDemo;

import com.relevantcodes.extentreports.LogStatus;
import main.MainMethods;
import org.openqa.selenium.By;

public class Checkout extends MainMethods {
    private final By subheder= By.xpath("//div[@class='header_secondary_container']");
    private final By firstName= By.xpath("//input[@id='first-name']");
    private final By lastName= By.xpath("//input[@id='last-name']");
    private final By zipCode= By.xpath("//input[@id='postal-code']");
    private final By continueButton=By.xpath("//input[@id='continue']");
    private final By total=By.xpath("//div[@class='summary_subtotal_label'][text()='Item total: $']");
    private final By finishButton= By.xpath("//button[@id='finish']");
    private final By success =By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");


    public Checkout verifySubheader(){
        verifyThatElementIsVisible(subheder);
        test.log(LogStatus.INFO, "[Checkout div] is visible");
        return this;
    }
    public Checkout enterFirstName() {
        type(firstName,"Peter");
        test.log(LogStatus.INFO, "[First name is typed");
        return this;
    }
    public Checkout enterLastName() {
        type(lastName,"Peter");
        test.log(LogStatus.INFO, "[Last name] is typed ");
        return this;
    }
    public Checkout enterZipCode() {
        type(zipCode,"3400");
        test.log(LogStatus.INFO, "[Zip code] is typed");
        return this;
    }
    public  Checkout clickOnContinueButton(){
        click(continueButton);
        test.log(LogStatus.INFO, "Continue button is clicked");
        return this;
    }
    public Checkout verifyTotalItem(){
        verifyThatElementIsVisible(total);
        test.log(LogStatus.INFO, "[Total item] is visible");
        return this;
    }
    public Checkout clickOnFinish(){
        click(finishButton);
        test.log(LogStatus.INFO, "Finish button is clicked");
        return this;
    }
    public Checkout verifySuccessfully(){
        verifyThatElementIsVisible(success);
        test.log(LogStatus.INFO, "[Thank you for order] is visible");
        return this;
    }
}

