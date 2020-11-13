package gooogle.simple.pageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.sbt.qa.uitest.pages.fluent.GoogleMainFluentPage;

public class GooglePageFactoryFluentTest {
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
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pageFactoryFluentTest() {
        new GoogleMainFluentPage(driver)
                .search("брокколи")
                .checkFirstSearchResult("Брокколи — Википедия",
                        "ru.wikipedia.org › wiki › Брокколи")
                .printFirstSearchResult();
    }
}
