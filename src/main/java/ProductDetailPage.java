import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage  extends BasePage{
    By descLocator= By.className("o-productDetail__description");
    By priceLocator= new By.ByXPath("//ins[@class='m-price__new']");

    By addToCartButtonLocator= By.id("addBasket");
    By cartPriceLocator= By.className("m-productPrice__salePrice");

    public String productPrc;
    public String cartPrc;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return  isDisplayed(addToCartButtonLocator);
    }
    public String getProductDetail(){

        String desc=driver.findElement(descLocator).getText();
        String price=driver.findElement(priceLocator).getText();
        return "Product descriction: "+desc+"\n"+"Product price: "+price;
    }
    public String getProductPrice(){
        productPrc=driver.findElement(priceLocator).getText();
        return productPrc;
    }
    public String getCartPrice(){
        cartPrc=driver.findElement(cartPriceLocator).getText();
        return cartPrc;
    }


}
