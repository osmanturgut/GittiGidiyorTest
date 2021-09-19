package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By approveCookie = By.xpath("//a/span[contains(text(),'Kapat')]");
    private By searchInput = By.xpath("//div[@class='sc-4995aq-4 dNPmGY']/input");
    private By secondPage = By.xpath("//ul/li/a/span[contains(text(),'2')]");
    private By sss = By.xpath("//div[@class='sc-4995aq-4 iHxzYS']/input");

    public void navigateTo(String url) {
        goToUrl(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void clickApproveCookie() {
        clickElement(approveCookie);
    }

    public void writeInSearchBox(String q) {
        sendKeys(searchInput, q + Keys.RETURN);

    }

}
