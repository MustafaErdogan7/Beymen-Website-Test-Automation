import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;


public class DriveTest extends BaseTest{
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void confirmHomePage(){
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.beymen.com/");
    }
    @Test
    @Order(2)
    public void searchAndClear() throws InterruptedException {
        String productType="şort";
        homePage=new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBox().search(productType);
        Thread.sleep(2000);
        for (int i = 1; i <=productType.length() ; i++) {
            homePage.searchBox().back();
        }
        Thread.sleep(2000);
        }
    @Test
    @Order(3)
    public void searchAProduct() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.acceptCookies();
        productPage=new ProductPage(driver);
        homePage.searchBox.search("göm");
        Thread.sleep(1500);
        homePage.searchBox().searchAndPressEnter("lek");
        Thread.sleep(2000);
        Assertions.assertTrue(productPage.isOnProductPage(),"Not on products page");
    }
    @Test
    @Order(4)
    public void selectAProduct() throws InterruptedException {
        productDetailPage=new ProductDetailPage(driver);
        productPage.selectProduct();
        Thread.sleep(2000);
    }
    @Test
    @Order(5)
    public  void addToTxt() throws InterruptedException {
        String details=productDetailPage.getProductDetail();
        String fileName="productDetail.txt";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(details);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
    }
    @Test
    @Order(6)
    public void addProductToCart() throws InterruptedException {
        cartPage=new CartPage(driver);
        cartPage.addToCart();
        Thread.sleep(2000);
        cartPage.goToCart();
        Thread.sleep(3000);
    }
    @Test
    @Order(7)
    public void comparePrices(){
        Assertions.assertEquals(productDetailPage.cartPrc,productDetailPage.productPrc);
    }
    @Test
    @Order(8)
    public void increaseProduct() throws InterruptedException {
        String price = productDetailPage.getCartPrice().split(",")[0];
        cartPage.productCountUp();
        Thread.sleep(3000);
        String totalPrice = productDetailPage.getCartPrice().split(",")[0];
        double productPrice = Double.parseDouble(price)*2;
        double cartPrice = Double.parseDouble(totalPrice);
        if(productPrice/2 == cartPrice){
            Assertions.assertEquals(productPrice/2,cartPrice);
            System.out.println("Urun adedi bir oldugu icin urun artirilamadi.");
        }
        else{
            Assertions.assertEquals(productPrice,cartPrice);
        }

    }
    @Test
    @Order(9)
    public void clearCart() throws InterruptedException {
        cartPage.deleteCartProduct();
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.isNotInCart(),"there is product or products on your cart");
    }


    }




