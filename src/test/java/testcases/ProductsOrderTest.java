package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ProductsOrderTest extends BaseTest {

    List<String> computerProduct = new ArrayList<>();
    List<String> electronicsProduct = new ArrayList<>();
    List<String> apparelProduct = new ArrayList<>();
    List<String> digitalDownloadProduct = new ArrayList<>();
    List<String> bookProduct = new ArrayList<>();
    List<String> jewelryProduct = new ArrayList<>();
    List<String> giftCardProduct = new ArrayList<>();
    LinkedHashMap<String, String> cartTable;
    
    SoftAssert softAssert = new SoftAssert();

    ProductsCategoryPage productsCategoryPage;
    CartPage cartPage;
    ProductDetailPage productDetailPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    OrderDetailsPage orderDetailsPage;

    @BeforeClass
    public void placeOrderSetup(){
        productsCategoryPage =pageObjectManager.getProductsCategoryPage();
        cartPage=pageObjectManager.getCartPage();
        productDetailPage=pageObjectManager.getProductDetailPage();
        loginPage=pageObjectManager.getLoginPage();
        checkoutPage=pageObjectManager.getCheckoutPage();
        orderDetailsPage=pageObjectManager.getOrderDetailsPage();
        loginPage.navigateToLoginPage();
        loginPage.enterCredentials(regEmailID, regPassword);
        loginPage.loginButtonClick();
    }

    @Test(priority = 1)
    public void selectProducts() throws InterruptedException {
        productsCategoryPage.computerClick();
        productsCategoryPage.productTitleClick();
        computerProduct.add(productDetailPage.getProductTitle());
        computerProduct.add(productDetailPage.getSku());
        computerProduct.add(productDetailPage.getProductPrice());
        computerProduct.add(productDetailPage.getQuantity());
        productDetailPage.addToCartClickWithFillMandatory();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.electronicsClick();
        productsCategoryPage.productTitleClick();
        electronicsProduct.add(productDetailPage.getProductTitle());
        electronicsProduct.add(productDetailPage.getSku());
        electronicsProduct.add(productDetailPage.getProductPrice());
        electronicsProduct.add(productDetailPage.getQuantity());
        productDetailPage.addToCartClickWithFillMandatory();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.apparelClick();
        productsCategoryPage.productTitleClick();
        apparelProduct.add(productDetailPage.getProductTitle());
        apparelProduct.add(productDetailPage.getSku());
        apparelProduct.add(productDetailPage.getProductPrice());
        apparelProduct.add(productDetailPage.getQuantity());
        productDetailPage.addToCartClickWithFillMandatory();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.digitalDownloadsClick();
        productsCategoryPage.productTitleClick();
        digitalDownloadProduct.add(productDetailPage.getProductTitle());
        digitalDownloadProduct.add(productDetailPage.getSku());
        digitalDownloadProduct.add(productDetailPage.getProductPrice());
        digitalDownloadProduct.add(productDetailPage.getQuantity());
        productDetailPage.addToCartClick();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.booksClick();
        productsCategoryPage.productTitleClick();
        bookProduct.add(productDetailPage.getProductTitle());
        bookProduct.add(productDetailPage.getSku());
        bookProduct.add(productDetailPage.getProductPrice());
        bookProduct.add(productDetailPage.getQuantity());
        productDetailPage.addToCartClick();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.jewelryClick();
        productsCategoryPage.productTitleClick();
        jewelryProduct.add(productDetailPage.getProductTitle());
        jewelryProduct.add(productDetailPage.getSku());
        jewelryProduct.add(productDetailPage.getProductPrice());
        jewelryProduct.add(productDetailPage.getQuantity());
        productDetailPage.jewelryAddToCartClick();
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();

        productsCategoryPage.giftCardsClick();
        productsCategoryPage.productTitleClick();
        giftCardProduct.add(productDetailPage.getProductTitle());
        giftCardProduct.add(productDetailPage.getSku());
        giftCardProduct.add(productDetailPage.getProductPrice());
        giftCardProduct.add(productDetailPage.getQuantity());
        productDetailPage.giftCardAddToCartClick("MS Dhoni","Bala");
        softAssert.assertEquals( productDetailPage.getSuccessPopText(),"The product has been added to your shopping cart");
        productDetailPage.closeSuccessPopup();
    }

    @Test(priority = 2)
    public void productDetailsTest() throws InterruptedException {
        productDetailPage.cartIconClick();
        cartTable =  cartPage.getCartTable();
        softAssert.assertEquals(computerProduct.get(0),cartTable.get("product1"));
        softAssert.assertEquals(computerProduct.get(1),cartTable.get("skuIDOfProduct1"));
        softAssert.assertEquals(computerProduct.get(2),cartTable.get("priceOfProduct1"));
        softAssert.assertEquals(computerProduct.get(3),cartTable.get("qtyOfProduct1"));

        softAssert.assertEquals(electronicsProduct.get(0),cartTable.get("product2"));
        softAssert.assertEquals(electronicsProduct.get(1),cartTable.get("skuIDOfProduct2"));
        softAssert.assertEquals(electronicsProduct.get(2),cartTable.get("priceOfProduct2"));
        softAssert.assertEquals(electronicsProduct.get(3),cartTable.get("qtyOfProduct2"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct2"),cartTable.get("qtyOfProduct2")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct2")),0.01);

        softAssert.assertTrue(cartTable.get("product3").contains(apparelProduct.get(0)));
        softAssert.assertEquals(apparelProduct.get(1),cartTable.get("skuIDOfProduct3"));
        softAssert.assertEquals(apparelProduct.get(2),cartTable.get("priceOfProduct3"));
        softAssert.assertEquals(apparelProduct.get(3),cartTable.get("qtyOfProduct3"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct3"),cartTable.get("qtyOfProduct3")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct3")),0.01);

        softAssert.assertEquals(digitalDownloadProduct.get(0),cartTable.get("product4"));
        softAssert.assertEquals(digitalDownloadProduct.get(1),cartTable.get("skuIDOfProduct4"));
        softAssert.assertEquals(digitalDownloadProduct.get(2),cartTable.get("priceOfProduct4"));
        softAssert.assertEquals(digitalDownloadProduct.get(3),cartTable.get("qtyOfProduct4"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct4"),cartTable.get("qtyOfProduct4")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct4")),0.01);

        softAssert.assertEquals(bookProduct.get(0),cartTable.get("product5"));
        softAssert.assertEquals(bookProduct.get(1),cartTable.get("skuIDOfProduct5"));
        softAssert.assertEquals(bookProduct.get(2),cartTable.get("priceOfProduct5"));
        softAssert.assertEquals(bookProduct.get(3),cartTable.get("qtyOfProduct5"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct5"),cartTable.get("qtyOfProduct5")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct5")),0.01);

        softAssert.assertTrue(cartTable.get("product6").contains(jewelryProduct.get(0)));
        softAssert.assertEquals(jewelryProduct.get(1),cartTable.get("skuIDOfProduct6"));
        softAssert.assertEquals(jewelryProduct.get(2),cartTable.get("priceOfProduct6"));
        softAssert.assertEquals(jewelryProduct.get(3),cartTable.get("qtyOfProduct6"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct6"),cartTable.get("qtyOfProduct6")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct6")),0.01);

        softAssert.assertEquals(giftCardProduct.get(0),cartTable.get("product7"));
        softAssert.assertEquals(giftCardProduct.get(1),cartTable.get("skuIDOfProduct7"));
        softAssert.assertEquals(giftCardProduct.get(2),cartTable.get("priceOfProduct7"));
        softAssert.assertEquals(giftCardProduct.get(3),cartTable.get("qtyOfProduct7"));
        softAssert.assertEquals( totalPriceFormat(cartTable.get("priceOfProduct7"),cartTable.get("qtyOfProduct7")),cartTotalPriceFormat(cartTable.get("totalPriceOfProduct7")),0.01);

        cartPage.removeRecurringProduct();
        cartPage.checkTermsOfService();
        cartPage.clickCheckout();

        checkoutPage.selectState();
        checkoutPage.enterCity("New York");
        checkoutPage.enterAddress("123 Main st");
        checkoutPage.enterZipCode("12345");
        checkoutPage.enterPhoneNumber("1234567890");
        checkoutPage.addressContinueButton();
        checkoutPage.shippingContinueButton();
        checkoutPage.paymentContinueButton();
        checkoutPage.paymentInfoContinueButton();
        String orderTotal = checkoutPage.getOrderTotalAmountText();
        checkoutPage.confirmOrderButton();

        softAssert.assertEquals(orderDetailsPage.getOrderCompletedTitle(),"Thank you");
        softAssert.assertEquals(orderDetailsPage.getThankYouMessage(),"Your order has been successfully processed!");
        String orderNum = orderDetailsPage.getOrderNumber();
        orderDetailsPage.clickDetailsLink();
        softAssert.assertEquals(orderTotal,orderDetailsPage.getOrderTotalAmount());
        softAssert.assertEquals(orderNum,orderDetailsPage.getOrderNumFromSummary());

    }

    public double totalPriceFormat(String qty, String price){
        double formatPrice = Double.parseDouble((qty.replaceAll("[^\\d.]", "")));
        int formatQty = Integer.parseInt(price.replaceAll("[^\\d]", ""));
        return formatPrice*formatQty;
    }

    public double cartTotalPriceFormat(String total){
      double formatTotal = Double.parseDouble(total.replaceAll("[^\\d.]", ""));
      return formatTotal;
    }

}
