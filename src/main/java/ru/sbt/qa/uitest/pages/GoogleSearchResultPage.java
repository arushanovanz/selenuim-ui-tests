package ru.sbt.qa.uitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbt.qa.uitest.elements.SearchResultBox;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchResultPage {

    @FindBy(xpath = "//div[@class= 'rc']")
    List <SearchResultBox> searchResultBoxList;

    public GoogleSearchResultPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }
    public void checkFirstSearchResult(String expectedLabel, String expectedUrl ){
        SearchResultBox firstsSearchResultBox = searchResultBoxList.get(0);
        String actualLabel = firstsSearchResultBox.getLabel();
        String actualUrl = firstsSearchResultBox.getUrl();
        assertAll( "Ожидаемый результат поиска не соответсвует действительному",()->assertEquals(expectedLabel,actualLabel),
                ()-> assertEquals(expectedUrl,actualUrl));
    }
}

