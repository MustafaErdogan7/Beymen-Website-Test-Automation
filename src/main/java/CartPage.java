import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class CartPage extends BasePage {
    By cartDeleteButton=By.id("removeCartItemBtn0-key-0");
    By cartProductUpLocator =By.id("quantitySelect0-key-0");
    By cartCountLocator= new By.ByXPath("//a[@class='o-header__userInfo--item bwi-cart-o -cart'] ");
    By addToCartButtonLocator= By.id("addBasket");
    By productSizeLocator=By.xpath("//*[@class='m-variation__item' or @class='m-variation__item -criticalStock']");
    By emptyCartLocator= By.className("m-empty__messageTitle");//By.xpath("//*[@class='m-empty__messageTitle']//*[text()='\"Sepetinizde Ürün Bulunmamaktadır\"']");

    List<WebElement> result;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void addToCart() throws InterruptedException {
        result = driver.findElements(productSizeLocator);
        Random random = new Random();
        int sizeType = random.nextInt(result.size());
        result.get(sizeType).click();
        Thread.sleep(2000);
        click(addToCartButtonLocator);
    }
    public void goToCart() {
        click(cartCountLocator);
    }
    public void productCountUp() {
        click(cartProductUpLocator);
        pressDown(cartProductUpLocator);
        pressEnter(cartProductUpLocator);
    }
    private int getCartCount(){
        String count= find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    public void deleteCartProduct(){
        click(cartDeleteButton);
    }
    public boolean isNotInCart() {
        return isDisplayed(emptyCartLocator);
    }
}
