package pages.SauceDemo;

import com.relevantcodes.extentreports.LogStatus;
import main.MainMethods;
import main.SeleneseException;
import org.openqa.selenium.By;

public class LoginOnSauceDemo extends MainMethods {
    private final By user=By.xpath("//input[@id='user-name']");
    private final By password=By.xpath("//input[@id='password']");
    private final By passwordForall=By.xpath("//h4[text()='Password for all users:']");
    private final By usernamesForAll=By.xpath("//h4[text()='Accepted usernames are:']");
    private final By loginButton=By.xpath(" //input[@id='login-button']");
    private final By nemasUser= By.xpath("//h3[text()='Epic sadface: Username is required']");
    private final By nemasUser2= By.xpath("//div[@class='error-message-container error']");
    private final By nemasnijedno=By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");

    private final By nemasPassword=By.xpath("//h3[text()='Epic sadface: Password is required']");

    public LoginOnSauceDemo verificationThathTittlePasswordForAllIsVisible(){
        verifyThatElementIsVisible(passwordForall);
        test.log(LogStatus.INFO, "[label password for all] is visible");
        return this;
    }
    public LoginOnSauceDemo verificationTittleUsernameForAll(){
        verifyThatElementIsVisible(usernamesForAll);
        test.log(LogStatus.INFO, "[label username for all] is visible");
        return this;
    }
    public LoginOnSauceDemo enterUsernameInInputField(String ime){
        try {
            Thread.sleep(300);
            type(user,ime);
            test.log(LogStatus.INFO, "[Username] is typed"+ime);
        }catch (Exception e){
            throw new SeleneseException("pucaj username");
        }

        return this;
    }
    public LoginOnSauceDemo typingPassword(String pass) {
        try {
            Thread.sleep(300);
            type(password,pass);
            test.log(LogStatus.INFO, "[Password] is typed"+pass);
        }catch (Exception e){
            throw new SeleneseException("pucaj password");
        }
        return this;
    }
    public Inventory clickOnLoginButton(){
        click(loginButton);
        test.log(LogStatus.INFO, "[Login Button] is clicked");
        return new Inventory();
    }
    public LoginOnSauceDemo verificationTittleYouDontHaveAUserIsNotVisible(){
        verifyThatElementIsNotVisible(nemasUser2);
        test.log(LogStatus.INFO, "[You dont have a user ] is not visible");
        return this;
    }
    public LoginOnSauceDemo verificationYouDontHaveAPass(){
        verifyThatElementIsNotVisible(nemasPassword);
        test.log(LogStatus.INFO, "[You dont have a password ] is not visible");
        return this;
    }

    public LoginOnSauceDemo verificationYouDontHaveAUsernameIsNowVisible(){
        try {
            Thread.sleep(300);
            verifyThatElementIsVisible(nemasUser);
        }catch (Exception e){
            throw new SeleneseException("Pucaj");
        }
        test.log(LogStatus.INFO, "[You dont have a password ] is not visible");
        return this;
    }
    public LoginOnSauceDemo verifyThatYouDontHaveAPassword(){
        try {
            Thread.sleep(300);
            verifyThatElementIsVisible(nemasPassword);
        }catch (Exception e){
            throw new SeleneseException("Pucaj");
        }

        test.log(LogStatus.INFO, "[You don't have a password] is now visible");
        return this;
    }
    public LoginOnSauceDemo verificationYouDontHaveUsernameAndPAssword(){
        verifyThatElementIsVisible(nemasnijedno);
        test.log(LogStatus.INFO, "[You don't have a username and password] is now visible");
        return this;
    }
}
