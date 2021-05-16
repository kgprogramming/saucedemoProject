package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainMethods extends SetUp {



    public void verifyThatElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void verifyThatElementIsNotVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    public void switchToIFrame(By element) {
        WebElement iFrame = getDriver().findElement(element);
        getDriver().switchTo().frame(iFrame);
    }


    public void click(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            throw new SeleneseException("down");
        }
    }
    public void clickWithAction(By locator) {
        try {
            Thread.sleep(300);
            WebElement el = getDriver().findElement(locator);
            Actions act = new Actions(getDriver());
            act.moveToElement(el).click().build().perform();
            Thread.sleep(300);
        } catch (Exception e) {
            throw new SeleneseException("Button is not clicked");
        }
    }
    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
   public Boolean checkIfElementIsVisible(By locator) {
        boolean isVisible = true;
        try {
            getDriver().findElement(locator);
        } catch (Exception e) {
            isVisible = false;
        }
        return isVisible;
    }

    public void clear(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).clear();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void waitForPageToBeLoaded() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(webDriver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
    }

    public void switchToTab(int numberOfTab) {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(numberOfTab));
    }

    public void closeTabAndSwitchToMain(int closeTab, int switchTab) {
        Set<String> handlesSet = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<>(handlesSet);
        getDriver().switchTo().window(handlesList.get(closeTab));
        getDriver().close();
        getDriver().switchTo().window(handlesList.get(switchTab));
    }
}

   
