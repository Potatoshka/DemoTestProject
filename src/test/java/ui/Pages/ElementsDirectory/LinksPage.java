package ui.Pages.ElementsDirectory;

import Elements.Link;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LinksPage {
    @Step("Click simple link")
    public LinksPage clickSimpleLink(){
        Link.byID("simpleLink").clickLink();
        switchTo().window(1);
        Assertions.assertEquals("https://demoqa.com/", url());
        return this;
    }

    @Step("Close window")
    public LinksPage closeTab(){
        closeWindow();
        return this;
    }

    @Step("Click dynamic link")
    public LinksPage clickDynamicLink(){
        Link.byID("dynamicLink").clickLink();
        switchTo().window(1);
        Assertions.assertEquals("https://demoqa.com/", url());
        return this;
    }

}
