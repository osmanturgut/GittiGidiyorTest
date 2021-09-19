package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class ProductPage extends BasePage {
    String productName;
    String productPrice;
    private final By addToCart = By.xpath("//button[@id='add-to-basket']");
    private final By cartHover = By.xpath("//a[@class='header-cart-hidden-link']");
    private final By secondPage = By.xpath("//ul/li/a/span[contains(text(),'2')]");

    public ProductPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void goToSecondPage() {
        scrollPageClick(secondPage);
        logger.info("ikinci sayfaya gidilir");
    }

    public String getCurrentUrl() {
        String secondPageUrl = getDriver().getCurrentUrl();
        logger.info(secondPageUrl + "olduğu kontrol edilir");
        return secondPageUrl;

    }

    public WebElement selectRandomProduct(String xpath) {
        List<WebElement> elements = findElements(By.xpath(xpath));
        int maxProducts = elements.size();
        Random random = new Random();
        int index = random.nextInt(maxProducts);
        WebElement element = findElement(By.xpath(xpath + "[" + index + "]"));
        productName = findElement(By.xpath(xpath + "[" + index + "]//h2")).getText();
        productPrice = findElement(By.xpath(xpath + "[" + index + "]//section/span")).getText();
        return element;
    }

    private WebElement getRondomProduct() {
        WebElement element = selectRandomProduct("(//article[contains(text(),product-card)])");
        return element;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        logger.info("ürün sayfasındaki fiyat");
        return productPrice;
    }

    public void clickRandomProduct() {
        getRondomProduct().click();
        logger.info("rastgele ürün seçilir");
    }

    public void clickAddToCart() {
        clickElement(addToCart);
        logger.info("seçilen ürün sepete eklenir");
    }

    public void goToCart() {
        clickElement(cartHover);
        logger.info("Sepete gidilir");
    }
}
