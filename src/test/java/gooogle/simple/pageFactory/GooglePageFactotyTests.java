package gooogle.simple.pageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.sbt.qa.uitest.pages.GoogleMainPage;
import ru.sbt.qa.uitest.pages.GoogleSearchResultPage;

public class GooglePageFactotyTests {
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

    @Disabled
    @DisplayName("Такой простой поиск брокколи")
    @Test
    public void pageFactoryTest(){
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        googleMainPage.search("брокколи");
        GoogleSearchResultPage googleSearchResultPage= new GoogleSearchResultPage(driver);
        googleSearchResultPage.checkFirstSearchResult("Брокколи — Википедия",
                "ru.wikipedia.org › wiki › Брокколи");
    }
}
