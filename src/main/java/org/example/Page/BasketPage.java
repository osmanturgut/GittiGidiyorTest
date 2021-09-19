package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BasketPage extends BasePage {
    private final By priceText = By.xpath("//div[@class='total-price']");
    private final By productSelect = By.xpath("//select[@class='amount']");
    private final By quantity = By.xpath("//div[@class='gg-input gg-input-select']");
    private final By count = By.xpath("//div[@class='gg-d-16 gg-m-14 detail-text']");
    private final By deletedButton = By.xpath("//div[@class='row']/a[@title='Sil']");
    private final By noProductText = By.xpath("//h2[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]");

    public BasketPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public String getTextPrice() {
        String priceInCart = findElement(priceText).getText();
        logger.info("Sepet Sayfasındaki Fiyat");
        return priceInCart;
    }

    public void increaseProduct() {
        selectDrobdown(productSelect, "2");
        logger.info("Ürün miktarı 2 yapılır");

    }

    public String getCountText() {
        String countText = findElement(count).getText();
        logger.info(countText + "miktarın 2 olduğu doğrulanır");
        return countText.replaceAll("[^0-9]", "");

    }

    public void deletedButton() {
        clickElement(deletedButton);
        logger.info("Sepetteki Ürünler Silinir");
    }

    public String getNoProductText() {
        logger.info("sepetin boş olduğu kontrol edilir");
        return findElement(noProductText).getText();
    }
}
