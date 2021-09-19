package org.example.Test;

import org.example.Page.BasketPage;
import org.example.Page.HomePage;
import org.example.Page.ProductPage;
import org.example.base.BaseTest;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class GittigidyorTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(GittigidyorTest.class.getName());

    @Test
    public void randomPurching() throws InterruptedException {
        HomePage homePage = new HomePage(driver, logger);
        ProductPage productPage = new ProductPage(driver, logger);
        BasketPage basketPage = new BasketPage(driver, logger);
        homePage.navigateTo("https://www.gittigidiyor.com");
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
}
