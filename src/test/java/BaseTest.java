import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
