package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class HomePage extends BasePage {


    private final By approveCookie = By.xpath("//a/span[contains(text(),'Kapat')]");
    private final By searchInput = By.xpath("//div[@class='sc-4995aq-4 dNPmGY']/input");

    public HomePage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void navigateTo(String url) {
        goToUrl(url);
        logger.info(url + "url'ye gidilir");
    }

    public String getTitle() {
        String title = getDriver().getTitle();
        logger.info(title + " title kontrol edildi");
        return title;


    }

    public void clickApproveCookie() {
        clickElement(approveCookie);
        logger.info("çerez politikası kabul edilir");

    }

    public void writeInSearchBox(String q) {
        sendKeys(searchInput, q + Keys.RETURN);
        logger.info("arama kutusuna bilgisayar yazılır ");


    }

}
