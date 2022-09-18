import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage  extends BasePage{
    List<WebElement> result;
    By shippingOptionLocator= By.xpath("//*[@id='productListTitle']//*[text()='\"gömlek\"']");
    By selectProductLocator=new By.ByXPath("//*[@class='m-productImageList__item']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public  void selectProduct() {
        result=driver.findElements(selectProductLocator);
        Random random = new Random();
        int linkNo = random.nextInt(result.size());
        result.get(linkNo).click();
    }
    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);

    }

}
