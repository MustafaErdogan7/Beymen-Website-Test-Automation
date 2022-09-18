import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void pressEnter(By locator){
        find(locator).sendKeys(Keys.ENTER);
    }
    public void pressDown(By locator){find(locator).sendKeys(Keys.DOWN);}
    public void pressBack(By locator){find(locator).sendKeys(Keys.BACK_SPACE);}
    public void writeText(By locator, String value){
        find(locator).sendKeys(value);
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

}
