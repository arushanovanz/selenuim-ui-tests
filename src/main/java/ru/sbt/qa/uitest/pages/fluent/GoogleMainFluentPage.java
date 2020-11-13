package ru.sbt.qa.uitest.pages.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class GoogleMainFluentPage {

    @FindBy(xpath = "//input[@name = 'q']")
    private TextInput searchInput;

    private WebDriver driver;


    public GoogleMainFluentPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
        this.driver = driver;
    }


    public GoogleSearchResultFluentPage search(String textInput){
        searchInput.sendKeys(textInput);
        searchInput.submit();
        return new GoogleSearchResultFluentPage(driver);
    }

}