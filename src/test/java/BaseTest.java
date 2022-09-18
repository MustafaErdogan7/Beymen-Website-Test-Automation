import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(Logs.class)
public class BaseTest {
    WebDriver driver;
    @BeforeAll
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        String url="https://www.beymen.com/";
        driver.get(url);
        driver.manage().window().maximize();

        // To move mouse to top-left of the page.
        try {
            Robot robot = new Robot();
            robot.mouseMove(0,0);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
