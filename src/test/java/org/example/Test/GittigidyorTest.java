package org.example.Test;

import org.example.Page.BasketPage;
import org.example.Page.HomePage;
import org.example.Page.ProductPage;
import org.example.base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class GittigidyorTest extends BaseTest {

    @Test
    public void openGittigidiyor() {
        HomePage homePage = new HomePage(driver);
        homePage.goToUrl("https://www.gittigidiyor.com");
        assertEquals(homePage.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
    }


    @Test
    public void randomPurching() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        homePage.goToUrl("https://www.gittigidiyor.com");
        assertEquals(homePage.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        homePage.clickApproveCookie();
        homePage.writeInSearchBox("Bilgisayar");
        productPage.goToSecondPage();
        assertEquals(productPage.getCurrentUrl(), "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2");
        productPage.clickRandomProduct();
        productPage.clickAddToCart();
        productPage.goToCart();
        assertEquals(productPage.getProductPrice(), basketPage.getTextPrice());
        basketPage.increaseProduct();
        Thread.sleep(3000);
        assertEquals(basketPage.getCountText(), "2");
        basketPage.deletedButton();
        Thread.sleep(8000);
        assertEquals(basketPage.getNoProductText(), "Sepetinizde ürün bulunmamaktadır.");
    }


    @Test
    public void dddd() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.navigateTo("https://www.gittigidiyor.com/bilgisayar-tablet/lenovo-ideacentre-3-90nb009ptx13-i3-10100-16gb-512ssd-freedos-masaustu-bilgisayar_pdp_690439178");
        homePage.clickElement(By.xpath("//span[contains(text(),'Kapat')]/parent::div"));
        productPage.clickAddToCart();
        productPage.goToCart();
        BasketPage basketPage = new BasketPage(driver);
        System.out.println(basketPage.getTextPrice());
        basketPage.increaseProduct();
        Thread.sleep(2000);
        System.out.println(basketPage.getCountText());
    }
}
