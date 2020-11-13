package ru.sbt.qa.uitest.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class SearchResultBox extends TypifiedElement {

    public SearchResultBox(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public String getLabel(){
        return getWrappedElement().findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).getText();
    }
    public String getUrl(){
        return getWrappedElement().findElement(By.xpath("//cite")).getText();
    }
}
