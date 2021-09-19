package org.example.Base;

import org.example.Page.HomePage;
import org.example.Page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30, 500);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void hoverElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        getActions().moveToElement(findElement(by)).build().perform();

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

    protected void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        if (element != null) {
            js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 3);", element);
            element.click();
        }

    }

    public WebElement visibleElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickVisibleElement(By by) {
        visibleElement(by).click();
    }

    public void sendKeys(By by, CharSequence text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(text);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }


    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public JavascriptExecutor getExecutor() {
        executor = (JavascriptExecutor) driver;
        return executor;
    }

    public void javascriptclicker(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = findElement(by);
        executor.executeScript("arguments[0].click();", element);
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

