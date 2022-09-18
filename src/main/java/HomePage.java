import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;

public class HomePage extends BasePage {
    SearchBox searchBox;
    By acceptCookiesLocator=By.id("onetrust-accept-btn-handler");
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox=new SearchBox(driver);
    }
    public SearchBox searchBox(){
        return this.searchBox;
    }
    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

    public String[] getSearchNames(){
        File f = new File("test.xlsx");
        FileInputStream fis;
        String[] searchNames = {"",""};
        try {
            fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);
            Row shirtRow = sheet.getRow(0);
            Row shorts = sheet.getRow(1);
            searchNames[0] = String.valueOf(shirtRow.getCell(0)) + String.valueOf(shirtRow.getCell(1));
            searchNames[1] = String.valueOf(shorts.getCell(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchNames;
    }
}
