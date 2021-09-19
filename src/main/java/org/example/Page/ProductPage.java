package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    String productName;
    String productPrice;
    private By addToCart=By.xpath("//button[@id='add-to-basket']");
    private By cartHover=By.xpath("//a[@class='header-cart-hidden-link']");
    //private By cartLink=By.xpath("//div[a[contains(text(),'Sepete Git')]]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By secondPage = By.xpath("//ul/li/a/span[contains(text(),'2')]");
    //xprivate By products = By.xpath("");


    public void goToSecondPage() {
        scrollPageClick(secondPage);
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }



    public WebElement selectRandomProduct(String xpath) {
        List<WebElement> elements = findElements(By.xpath(xpath));
        int maxProducts = elements.size();
        Random random = new Random();
        int index = random.nextInt(maxProducts);
        WebElement element=findElement(By.xpath(xpath+"["+index+"]"));
        productName =        findElement(By.xpath(xpath+"["+index+"]//h2")).getText();
        productPrice =        findElement(By.xpath(xpath+"["+index+"]//section/span")).getText();


        return element;
    }
    private WebElement getRondomProduct(){
        WebElement element =selectRandomProduct("(//article[contains(text(),product-card)])");
       return element;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

   public void clickRandomProduct(){
        getRondomProduct().click();
        System.out.println(productPrice + productName);
    }

    public void  clickAddToCart(){
         clickElement(addToCart);

    }
    public void goToCart(){
        clickElement(cartHover);

    }
}
