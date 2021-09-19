package org.example.Page;

import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    private By priceText = By.xpath("//div[@class='total-price']");
    private By productSelect = By.xpath("//select[@class='amount']");
    private By quantity = By.xpath("//div[@class='gg-input gg-input-select']");
    private By count= By.xpath("//div[@class='gg-d-16 gg-m-14 detail-text']");
    private By deletedButton=By.xpath("//div[@class='row']/a[@title='Sil']");
    private By noProductText=By.xpath("//h2[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]");;

    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public String getTextPrice() {
        return findElement(priceText).getText();
    }

    public void increaseProduct() {
        selectDrobdown(productSelect,"2");
     }
     public  String getCountText(){
         String countText= findElement(count).getText();
         return countText.replaceAll("[^0-9]", "");

     }

     public void deletedButton(){
        clickElement(deletedButton);
     }

    public  String getNoProductText(){
         return findElement(noProductText).getText();

    }


}
