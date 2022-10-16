package com.dmgt.context;

import lombok.Data;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Set;

@Data
public class Base {
    private WebDriver driver;

    public String getAttribute(By by,String attribute){
        return driver.findElement(by).getAttribute(attribute);
    }

    public void waitForElementToClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void scrollToView(By by) {
        WebElement webElement = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void hover(By by) {
        Actions actions = new Actions(driver);
        WebElement webElement1 = driver.findElement(by);
        actions.moveToElement(webElement1);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void jsClick(By by) {
        WebElement webElement = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }
@SneakyThrows
    public boolean isWindowSwitched(String url) {
    Thread.sleep(4000);
    Set<String> windows = driver.getWindowHandles();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (String window : windows) {
            Thread.sleep(2000);
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(url)) {
                js.executeScript("window.scrollBy(0,400)");
                return true;
            }
        }
        return false;
    }
}
