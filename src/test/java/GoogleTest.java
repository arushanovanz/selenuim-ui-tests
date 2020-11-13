import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    private WebDriver driver;

    @BeforeAll
    public static void checkBrowser() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }
    @AfterEach
    public void tearDown(){
        if (driver!= null){
            driver.quit();
        }
    }

    @Test
    public void simpleTest(){
        String xpath ="//input[@name = 'q']";
     WebElement inputElement= driver.findElement(By.xpath(xpath));
     inputElement.sendKeys("соус вассаби");
     inputElement.submit();
    }
}
