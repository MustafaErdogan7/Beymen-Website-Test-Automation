import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {
    By searchBoxLocator= new By.ByXPath("//input[@class='default-input o-header__search--input']");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void searchAndPressEnter(String text) {
        writeText(searchBoxLocator,text);
        pressEnter(searchBoxLocator);
    }
    public void search(String text){
        writeText(searchBoxLocator,text);
    }
    public void back(){
        pressBack(searchBoxLocator);
    }
}
