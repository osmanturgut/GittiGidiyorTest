package org.example.Test;

import org.example.Page.BasketPage;
import org.example.Page.ProductPage;
import org.example.base.BaseTest;
import org.example.Page.HomePage;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @Before
    public void Before() {
        homePage = new HomePage(driver);
    }


    @Test
    public void HomePageTest() {


    }
}
