package org.example.Test;

import org.example.base.BaseTest;
import org.example.Page.ProductPage;
import org.junit.Before;
import org.junit.Test;

public class ProductPageTest extends BaseTest {

    ProductPage productPage;

    @Before
    public void before() {
        productPage = new ProductPage(driver);
    }

    @Test
    public void productPageTest() {


    }

}
