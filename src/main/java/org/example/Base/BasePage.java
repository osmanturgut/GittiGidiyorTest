package org.example.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;
    protected static  Logger logger ;


    public BasePage(WebDriver driver ,Logger logger ) {
        this.driver = driver;
        this.logger=logger;
        wait = new WebDriverWait(this.driver, 30, 500);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    public void clickElement(By by) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollPageClick(By by) {
        WebElement element = findElement(by);
        getExecutor().executeScript("arguments[0].scrollIntoView()", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(By by, CharSequence text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(text);
    }

    public JavascriptExecutor getExecutor() {
        executor = (JavascriptExecutor) driver;
        return executor;
    }

    public void selectDrobdown(By by, String text) {
        WebElement element = findElement(by);
        Select selected = new Select(element);
        selected.selectByVisibleText(text);

    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

